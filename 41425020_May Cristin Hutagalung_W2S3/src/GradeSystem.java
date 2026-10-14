/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Nim     : 41425020
Nama    : May Cristin Hutagalung
*/

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;

public class GradeSystem {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array untuk menyimpan 5 nilai mahasiswa
        double[] grades = new double[5];
        double total = 0;

        // Input nilai sebanyak 5 kali menggunakan perulangan for
        for (int i = 0; i < 5; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i]; // akumulasi total nilai
        }

        // Hitung rata-rata dari total nilai dibagi jumlah data
        double average = total / 5;
        System.out.println("Rata-rata nilai: " + average);

        // Kategorikan nilai rata-rata menjadi huruf A-E
        // menggunakan struktur percabangan if-else if berantai
        char grade;
        if (average >= 85) grade = 'A';
        else if (average >= 70) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 50) grade = 'D';
        else grade = 'E';

        System.out.println("Grade: " + grade);

        // Cari nilai tertinggi dan terendah dengan menelusuri array
        double max = grades[0];
        double min = grades[0];

        for (int i = 1; i < 5; i++) {
            if (grades[i] > max) max = grades[i]; // update jika ditemukan nilai lebih besar
            if (grades[i] < min) min = grades[i]; // update jika ditemukan nilai lebih kecil
        }

        System.out.println("Nilai tertinggi: " + max);
        System.out.println("Nilai terendah: " + min);

        scanner.close();
    }
}

// Pertanyaan Pemantik //
-- // - Apa yang terjadi jika ada nilai yang diinput di luar rentang 0-100?
// Jawab : Jika nilai diinput di luar rentang standar 0–100 pada sistem 
// penilaian pendidikan (seperti aplikasi e-Rapor atau Learning Management 
// System / LMS), hal yang akan terjadi umumnya terbagi menjadi dua skenario 
// teknis: penolakan otomatis (error validation) atau kerusakan kalkulasi 
// data (invalid calculation).

// - Bagaimana cara memodifikasi program untuk menangani jumlah nilai yang dinamis?
// Jawab : Untuk menangani jumlah nilai secara dinamis dalam pemrograman, 
// Kita perlu mengganti struktur data berukuran tetap (seperti array 
// tradisional) dengan struktur data dinamis atau menggunakan alokasi memori 
// dinamis.



