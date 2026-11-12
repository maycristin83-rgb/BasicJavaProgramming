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

import java.util.Timer;
import java.util.TimerTask;

public class Tugas1_Reminder {

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Jadwalkan tugas yang berjalan sekali setelah 15 detik (15000 ms)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time's up!");
                timer.cancel(); // hentikan timer agar program berakhir
            }
        }, 15000);

        // Langsung tampil, tanpa menunggu
        System.out.println("Task scheduled."); // Code ini berfungsi untuk memanggil time' up!.lalu akan diikuti dengan timer.cancel untuk menghentikan thread
    }
}

/* 
Objek Timer dibuat. Timer punya thread latar belakang sendiri untuk menjalankan tugas terjadwal.
timer.schedule(tugas, 15000) menjadwalkan sebuah TimerTask yang dijalankan satu kali setelah 15000 milidetik (15 detik).
Setelah penjadwalan, program langsung mencetak Task scheduled. (Output 1).
Selama 15 detik program terlihat diam. Penundaan itu dilakukan oleh penjadwalan Timer, bukan oleh sleep().
Setelah 15 detik, run() pada TimerTask dipanggil dan mencetak time's up! (Output 2). Lalu timer.cancel() menghentikan thread timer sehingga program berakhir.

*/