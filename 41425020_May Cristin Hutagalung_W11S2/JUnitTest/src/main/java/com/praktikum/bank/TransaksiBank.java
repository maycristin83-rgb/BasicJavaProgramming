/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.bank;

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

public class TransaksiBank {
    public static void main(String[] args) throws InterruptedException {
        // Membuat rekening baru dengan saldo awal 0
        RekeningBank rekening = new RekeningBank(0);
        
        // Array untuk menampung 100 thread
        Thread[] threads = new Thread[100];

        // Membuat dan menjalankan 100 thread secara paralel
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> rekening.setor(1000));
            threads[i].start();
        }

        // Menunggu semua thread selesai (join)
        for (Thread t : threads) {
            t.join();
        }

        // Mencetak hasil
        System.out.println("Saldo Seharusnya : 100000");
        System.out.println("Saldo Aktual     : " + rekening.getSaldo());
    }
}



/*
public class TransaksiBank {
    public static void main(String[] args) throws InterruptedException {
        // Membuat rekening baru dengan saldo awal 0
        RekeningBank rekening = new RekeningBank(0);
        
        // Menyiapkan array untuk 100 thread
        Thread[] threads = new Thread[100];

        // Membuat dan menjalankan 100 thread secara bersamaan (paralel)
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> rekening.setor(1000));
            threads[i].start();
        }

        // Menunggu semua thread selesai mengeksekusi tugasnya
        for (Thread t : threads) {
            t.join();
        }

        // Mencetak hasil akhir
        System.out.println("Saldo Seharusnya : 100000");
        System.out.println("Saldo Aktual     : " + rekening.getSaldo());
    }
}
*/