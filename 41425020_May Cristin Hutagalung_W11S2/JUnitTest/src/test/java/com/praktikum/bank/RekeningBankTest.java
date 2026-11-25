/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.praktikum.bank;
// LATIHAN MANDIRI SOAL 3 //
// Untuk menentukan batas waktu maksimal pada assertTimeoutPreemptively
import java.time.Duration;
// Exception yang dilempar tarikDenganTunggu(jumlah, timeout) jika waktu habis (Soal 2)
import java.util.concurrent.TimeoutException;
// Penghitung mundur: menunggu sampai semua thread selesai
import java.util.concurrent.CountDownLatch;
// Antarmuka untuk mengelola kumpulan thread (thread pool)
import java.util.concurrent.ExecutorService;
// Pabrik untuk membuat thread pool
import java.util.concurrent.Executors;
// Anotasi: method ini dijalankan sebelum setiap test
import org.junit.jupiter.api.BeforeEach;
// Anotasi: menandai method sebagai test
import org.junit.jupiter.api.Test;
// Semua method assert (assertEquals, assertThrows, dll.)
import static org.junit.jupiter.api.Assertions.*;
// Anotasi: nama test yang tampil di jendela Test Results
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author MyBook Hype AMD
 */
public class RekeningBankTest {

    // Objek rekening yang dipakai di tiap test
    private RekeningBank rekening;

    // Dijalankan sebelum SETIAP test, agar tiap test mulai dari kondisi bersih
    @BeforeEach
    void setUp() {
        // Buat rekening baru dengan saldo awal 0
        rekening = new RekeningBank(0);
    }

    

    // Menandai method di bawah ini sebagai test
    @Test
    // Nama yang tampil di Test Results
    @DisplayName("Skenario 1: Transaksi setor dan tarik normal secara sekuensial")
    // throws InterruptedException karena tarikDenganTunggu bisa melemparnya
    void testTransaksiNormal() throws InterruptedException {
        // Setor 50000, saldo menjadi 50000
        rekening.setor(50000);
        // Tarik 20000, saldo menjadi 30000
        rekening.tarikDenganTunggu(20000);
        // Cek saldo akhir harus 30000 (nilai harapan, nilai aktual, pesan jika gagal)
        assertEquals(30000, rekening.getSaldo(), "Saldo akhir harus tepat 30000");
    }

    @Test
    @DisplayName("Skenario 2: Input nominal negatif atau nol harus melempar Exception")
    void testInputTidakValid() {
        // assertThrows lulus jika kode di dalam lambda melempar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            // Setor nominal negatif, harus ditolak
            rekening.setor(-5000);
        }, "Setor negatif harus ditolak dengan IllegalArgumentException");
    }

    @Test
    @DisplayName("Skenario 3: Bebas Race Condition pada eksekusi 100 Thread bersamaan")
    void testConcurrencySetor() throws InterruptedException {
        // Jumlah thread yang menyetor bersamaan
        int jumlahThread = 100;
        // Nominal tiap setoran
        int nominalSetor = 1000;
        // Thread pool berisi 20 thread untuk menjalankan 100 tugas
        ExecutorService executor = Executors.newFixedThreadPool(20);
        // Latch dengan hitungan 100, berkurang 1 tiap tugas selesai
        CountDownLatch latch = new CountDownLatch(jumlahThread);

        // Kirim 100 tugas setor ke thread pool
        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    // Setor 1000 ke rekening yang sama
                    rekening.setor(nominalSetor);
                } finally {
                    // Kurangi hitungan latch, walau terjadi exception
                    latch.countDown();
                }
            });
        }

        // Tunggu sampai hitungan latch mencapai 0 (semua setoran selesai)
        latch.await();
        // Matikan thread pool
        executor.shutdown();

        // 100 x 1000 = 100000, harus tepat tanpa ada data yang hilang
        assertEquals(100000, rekening.getSaldo(),
            "Saldo harus tepat 100000 tanpa kehilangan data akibat race condition");
    }

    @Test
    @DisplayName("Skenario 4: Koordinasi Thread menggunakan wait() dan notifyAll()")
    void testWaitNotifyTarikTunggu() {
        // Jika blok di dalam tidak selesai dalam 2 detik, test dihentikan paksa dan gagal
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            // Thread penarik: mencoba menarik 50000 padahal saldo masih 0
            Thread threadPenarik = new Thread(() -> {
                try {
                    // Thread ini akan wait() sampai saldo cukup
                    rekening.tarikDenganTunggu(50000);
                } catch (InterruptedException e) {
                    // Kembalikan status interrupt agar tidak hilang
                    Thread.currentThread().interrupt();
                }
            });

            // Thread penyetor: menyetor setelah penarik sudah menunggu
            Thread threadPenyetor = new Thread(() -> {
                try {
                    // Tunda 200 ms supaya penarik sempat masuk keadaan menunggu
                    Thread.sleep(200);
                    // Setor 70000, notifyAll() akan membangunkan penarik
                    rekening.setor(70000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            // Jalankan kedua thread
            threadPenarik.start();
            threadPenyetor.start();

            // Tunggu kedua thread selesai
            threadPenarik.join();
            threadPenyetor.join();

            // 0 + 70000 - 50000 = 20000
            assertEquals(20000, rekening.getSaldo(),
                "Thread penarik harus menunggu penyetor, lalu saldo tersisa 20000");
        });
    }

    

    // [LATIHAN 3a] Menguji transfer paralel dua arah (Soal 1)
    @Test
    @DisplayName("Skenario 5: Transfer paralel dua arah, total saldo konsisten & tanpa deadlock")
    void testTransferParalel() {
        // Dua rekening dengan saldo awal masing-masing 100000
        RekeningBank a = new RekeningBank(100000);
        RekeningBank b = new RekeningBank(100000);

        // Jika terjadi deadlock, test dihentikan paksa setelah 5 detik dan dinyatakan gagal
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            // Pool 20 thread untuk menjalankan 100 transfer secara bersamaan
            ExecutorService executor = Executors.newFixedThreadPool(20);
            // Latch menunggu sampai semua 100 transfer selesai
            CountDownLatch latch = new CountDownLatch(100);

            for (int i = 0; i < 100; i++) {
                // Genap: A -> B, ganjil: B -> A (saling transfer bersamaan)
                final boolean arahAkeB = (i % 2 == 0);
                executor.submit(() -> {
                    try {
                        if (arahAkeB) {
                            // Transfer 1000 dari A ke B
                            a.transfer(b, 1000);
                        } else {
                            // Transfer 1000 dari B ke A
                            b.transfer(a, 1000);
                        }
                    } finally {
                        // Pastikan latch selalu dikurangi, walau terjadi exception
                        latch.countDown();
                    }
                });
            }

            // Tunggu semua transfer selesai, lalu matikan pool
            latch.await();
            executor.shutdown();
        });

        // Uang tidak boleh hilang atau bertambah: total harus tetap 200000
        assertEquals(200000, a.getSaldo() + b.getSaldo(), "Total saldo harus tetap 200000");
        // Transfer seimbang (50 kali tiap arah), jadi saldo kembali ke nilai awal
        assertEquals(100000, a.getSaldo(), "Saldo A harus kembali 100000");
        assertEquals(100000, b.getSaldo(), "Saldo B harus kembali 100000");
    }

    // [LATIHAN 3b] Menguji timeout penarikan dana (Soal 2)
    @Test
    @DisplayName("Skenario 6: Penarikan timeout jika penyetor tidak datang")
    void testTarikTimeout() {
        // Saldo 0, tarik 5000, tunggu maksimal 300 ms, tidak ada penyetor.
        // Harus melempar TimeoutException
        assertThrows(TimeoutException.class,
            () -> rekening.tarikDenganTunggu(5000, 300),
            "Harus timeout karena tidak ada penyetor");

        // Penarikan yang gagal tidak boleh mengubah saldo
        assertEquals(0, rekening.getSaldo(), "Saldo tidak boleh berubah setelah timeout");
    }
}

/*
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class RekeningBankTest {

    private RekeningBank rekening;

    @BeforeEach
    void setUp() {
        rekening = new RekeningBank(0);
    }

    @Test
    @DisplayName("Skenario 1: Transaksi setor dan tarik normal secara sekuensial")
    void testTransaksiNormal() throws InterruptedException {
        rekening.setor(50000);
        rekening.tarikDenganTunggu(20000);
        assertEquals(30000, rekening.getSaldo(), "Saldo akhir harus tepat 30000");
    }

    @Test
    @DisplayName("Skenario 2: Input nominal negatif atau nol harus melempar Exception")
    void testInputTidakValid() {
        assertThrows(IllegalArgumentException.class, () -> {
            rekening.setor(-5000);
        }, "Setor negatif harus ditolak dengan IllegalArgumentException");
    }

    @Test
    @DisplayName("Skenario 3: Bebas Race Condition pada eksekusi 100 Thread bersamaan")
    void testConcurrencySetor() throws InterruptedException {
        int jumlahThread = 100;
        int nominalSetor = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(jumlahThread);

        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    rekening.setor(nominalSetor);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        assertEquals(100000, rekening.getSaldo(),
            "Saldo harus tepat 100000 tanpa kehilangan data akibat race condition");
    }

    @Test
    @DisplayName("Skenario 4: Koordinasi Thread menggunakan wait() dan notifyAll()")
    void testWaitNotifyTarikTunggu() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            Thread threadPenarik = new Thread(() -> {
                try {
                    rekening.tarikDenganTunggu(50000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread threadPenyetor = new Thread(() -> {
                try {
                    Thread.sleep(200);
                    rekening.setor(70000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            threadPenarik.start();
            threadPenyetor.start();

            threadPenarik.join();
            threadPenyetor.join();

            assertEquals(20000, rekening.getSaldo(),
                "Thread penarik harus menunggu penyetor, lalu saldo tersisa 20000");
        });
    }
}


/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MyBook Hype AMD

public class RekeningBankTest {
    
    public RekeningBankTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setor method, of class RekeningBank.
    
    @Test
    public void testSetor() {
        System.out.println("setor");
        int jumlah = 0;
        RekeningBank instance = null;
        instance.setor(jumlah);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tarik method, of class RekeningBank.
    
    @Test
    public void testTarik() throws Exception {
        System.out.println("tarik");
        int jumlah = 0;
        RekeningBank instance = null;
        instance.tarik(jumlah);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaldo method, of class RekeningBank.
    
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        RekeningBank instance = null;
        int expResult = 0;
        int result = instance.getSaldo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
*/