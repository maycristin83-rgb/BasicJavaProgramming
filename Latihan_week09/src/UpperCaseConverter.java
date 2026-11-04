/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.io.*; // Mengimpor seluruh kelas di package java.io untuk menangani operasi Input/Output file

public class UpperCaseConverter { // Mendefinisikan kelas utama bernama UpperCaseConverter
    public static void main(String[] args) { // Metode utama (entry point) tempat program mulai dieksekusi
        // Membuka try-with-resources agar stream file otomatis tertutup setelah selesai digunakan
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt")); // Membaca file input.txt secara efisien menggunakan BufferedReader
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){ // Menulis ke file output.txt menggunakan BufferedWriter
            
                String line; // Mendeklarasikan variabel string untuk menampung teks per baris
                // Melakukan perulangan membaca file baris demi baris hingga mencapai akhir file (null)
                while ((line = br.readLine()) != null) { 
                    bw.write(line.toUpperCase()); // Mengubah teks baris saat ini menjadi huruf besar lalu menulisnya ke file output
                    bw.newLine(); // Menambahkan karakter baris baru (enter) pada file output
                }
                System.out.println("Konversi selesai!"); // Menampilkan pesan sukses ke konsol jika proses baca-tulis tuntas
        } catch (IOException e) { // Menangkap error yang mungkin terjadi selama proses pembacaan/penulisan file
            System.out.println("Terjadi error: " + e.getMessage()); // Menampilkan detail pesan error ke konsol
        }
    }
}