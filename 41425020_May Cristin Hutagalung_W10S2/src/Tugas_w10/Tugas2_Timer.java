/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_w10;

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Tugas2_Timer {

    public static void main(String[] args) {
        System.out.println("Program started");

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                count++;
                System.out.println("Time started at:" + new Date());
                try {
                    Thread.sleep(5000); // proses selama 5 detik
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Time finished at:" + new Date());

                // Berhenti setelah 3 kali eksekusi
                if (count == 3) {
                    timer.cancel();
                    System.out.println("Program cancelled");
                }
            }
        };

        // Mulai langsung (delay 0), ulangi setiap 10 detik
        timer.scheduleAtFixedRate(task, 0, 10000);
    }
}

/*
PENJELASAN :
Program mencetak Program started, lalu membuat objek Timer.
Lalu TimerTask dibuat dengan variabel count untuk menghitung berapa kali tugas sudah dijalankan.
timer.scheduleAtFixedRate(task, 0, 10000) menjalankan tugas langsung (delay 0) dan mengulanginya dengan laju tetap setiap 10 detik.
Setiap kali run() dipanggil, program mencetak Time started at: dengan new Date(). Lalu tugas diproses selama 5 detik dengan Thread.sleep(5000), yang di Tugas 2 ini tidak dilarang. Terakhir program mencetak Time finished at:. Karena itu waktu mulai dan selesai selalu berselisih 5 detik, dan eksekusi berikutnya dimulai 10 detik setelah eksekusi sebelumnya.
Setelah eksekusi ke-3 (count == 3), timer.cancel() menghentikan penjadwalan dan program mencetak Program cancelled.
*/