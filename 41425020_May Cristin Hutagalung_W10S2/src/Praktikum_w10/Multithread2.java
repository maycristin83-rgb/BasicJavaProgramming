/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum_w10;

/**
 *
 * @author MyBook Hype AMD
 */


/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

class PrintNameThread2 implements Runnable {
    private Thread thread;
    private String symbol;
    private int printCount;
    private int delay;

    PrintNameThread2(String symbol, int printCount, int delay) {
        this.symbol = symbol;
        this.printCount = printCount;
        this.delay = delay;
        thread = new Thread(this, "Thread-" + symbol);
        System.out.println("Membuat " + thread.getName());
        thread.start();
    }

    public void run() {
        System.out.println(thread.getName() + " memulai eksekusi...");
        for (int i = 1; i <= printCount; i++) {
            // PAKAI print() BUKAN println() AGAR HURUF MENYAMBUNG KE SAMPING
            System.out.print(symbol);
            
            // Menampilkan angka setiap 10 kali cetak
            if (i % 10 == 0) {
                System.out.print("[" + i + "]");
            }
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("\n" + thread.getName() + " terinterupsi!");
                return;
            }
        }
        System.out.println("\n" + thread.getName() + " selesai mencetak " + printCount + " karakter!");
    }

    // Method tambahan agar main() bisa berjalan tanpa error
    public void waitForCompletion() throws InterruptedException {
        thread.join();
    }
}

public class Multithread2 {
    public static void main(String[] args) {
        System.out.println("================== PROGRAM MULTI-THREADING DENGAN RUNNABLE ==================");
        System.out.println("=============================================================================\n");

        PrintNameThread2[] threads = {
            new PrintNameThread2("A", 25, 50),
            new PrintNameThread2("B", 20, 80),
            new PrintNameThread2("C", 30, 40),
            new PrintNameThread2("D", 15, 120),
            new PrintNameThread2("E", 10, 150)
        };

        System.out.println("\nMenunggu semua thread selesai...\n");

        try {
            for (PrintNameThread2 thread : threads) {
                thread.waitForCompletion();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread terinterupsi!");
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("STATISTIK EKSEKUSI THREAD:");
        System.out.println("=".repeat(50));
        System.out.println("Jumlah thread yang dijalankan: " + threads.length);
        System.out.println("Total semua thread telah menyelesaikan tugasnya!");
        System.out.println("\nPROGRAM SELESAI DENGAN SUKSES!");

        System.out.println("\nAnimasi selesai:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Hore.. ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}