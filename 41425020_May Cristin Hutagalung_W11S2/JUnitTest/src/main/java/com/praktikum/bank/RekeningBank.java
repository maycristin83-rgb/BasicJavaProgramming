/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.bank;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;


/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/




// LATIHAN MANDIRI SOAL NO 1 //
public class RekeningBank {
    private int saldo;

    // [LATIHAN 1] ID unik tiap rekening, dipakai untuk menentukan urutan penguncian saat transfer
    private static final AtomicLong GENERATOR_ID = new AtomicLong();
    private final long id = GENERATOR_ID.incrementAndGet();

    public RekeningBank(int saldoAwal) {
        this.saldo = saldoAwal;
    }

    

    public synchronized void setor(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus lebih dari 0");
        }
        int saldoSementara = this.saldo;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;

        notifyAll();
    }

    public synchronized void tarikDenganTunggu(int jumlah) throws InterruptedException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }

        while (this.saldo < jumlah) {
            wait();
        }

        this.saldo -= jumlah;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    // ===================== LATIHAN MANDIRI =====================

    /**
     * [LATIHAN 1] Transfer dana dari rekening ini ke rekening tujuan.
     * Aman dari race condition dan deadlock.
     */
    public void transfer(RekeningBank tujuan, int jumlah) {
        // Validasi input: tujuan tidak boleh null atau rekening sendiri
        if (tujuan == null || tujuan == this) {
            throw new IllegalArgumentException("Rekening tujuan tidak valid");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah transfer harus lebih dari 0");
        }

        // LOCK ORDERING: selalu kunci rekening ber-ID lebih kecil lebih dulu.
        // Tanpa ini, transfer A->B dan B->A bersamaan bisa saling menunggu (deadlock).
        RekeningBank pertama = (this.id < tujuan.id) ? this : tujuan;
        RekeningBank kedua = (pertama == this) ? tujuan : this;

        synchronized (pertama) {
            synchronized (kedua) {
                // Cek saldo, kurangi, dan tambah dalam satu critical section
                // agar tidak ada thread lain yang menyela di tengah proses
                if (this.saldo < jumlah) {
                    throw new IllegalStateException("Saldo tidak mencukupi untuk transfer");
                }
                this.saldo -= jumlah;
                tujuan.saldo += jumlah;

                // Bangunkan thread yang mungkin menunggu saldo di rekening tujuan
                tujuan.notifyAll();
            }
        }
    }
    // LATIHAN MANDIRI SOAL 2//
    /**
     * [LATIHAN 2] Tarik dana dengan batas waktu tunggu.
     * Jika saldo belum cukup sampai timeout, lempar TimeoutException.
     */
    public synchronized void tarikDenganTunggu(int jumlah, long timeoutMillis)
            throws InterruptedException, TimeoutException {
        // Validasi input
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }
        if (timeoutMillis <= 0) {
            throw new IllegalArgumentException("Timeout harus lebih dari 0");
        }

        // Batas waktu absolut (nanoTime tidak terpengaruh perubahan jam sistem)
        long batas = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);

        while (this.saldo < jumlah) {
            // Hitung sisa waktu tunggu setiap kali thread bangun
            long sisaMillis = TimeUnit.NANOSECONDS.toMillis(batas - System.nanoTime());

            // WAJIB dicek: wait(0) berarti menunggu SELAMANYA, bukan "tidak menunggu"
            if (sisaMillis <= 0) {
                throw new TimeoutException("Timeout: saldo tidak mencukupi untuk menarik " + jumlah);
            }
            wait(sisaMillis);
        }

        this.saldo -= jumlah;
    }
}



/*
public class RekeningBank {
    private int saldo;

    public RekeningBank(int saldoAwal) {
        this.saldo = saldoAwal;
    }

    public synchronized void setor(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus lebih dari 0");
        }
        int saldoSementara = this.saldo;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;

        notifyAll();
    }

    public synchronized void tarikDenganTunggu(int jumlah) throws InterruptedException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }

        while (this.saldo < jumlah) {
            wait();
        }

        this.saldo -= jumlah;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}
/*
public class RekeningBank {
    private int saldo;

    public RekeningBank(int saldoAwal) {
        this.saldo = saldoAwal;
    }

    public void setor(int jumlah) {
        int saldoSementara = this.saldo;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;
    }

    public void tarik(int jumlah) {
        if (this.saldo >= jumlah) {
            int saldoSementara = this.saldo;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.saldo = saldoSementara - jumlah;
        }
    }

    public int getSaldo() {
        return saldo;
    }
}
*/