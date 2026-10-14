/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*  Nim  : 41425020
    Nama : May Cristin Hutagalung
*/
/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;

public class TimeCoverter {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Konverter Waktu ===");
        System.out.println("1. Detik ke HH:MM:SS");
        System.out.println("2. HH:MM:SS ke detik");
        System.out.print("Pilihan: ");
        int pilihan = Integer.parseInt(scanner.nextLine().trim());

        if (pilihan == 1) {
            
            // Dapat Mengonversi total detik menjadi format 
            System.out.print("Masukkan jumlah detik: ");
            int totalSeconds = Integer.parseInt(scanner.nextLine().trim());

            int hours = totalSeconds / 3600;               // jumlah jam penuh
            int minutes = (totalSeconds % 3600) / 60;      // sisa detik diubah ke menit
            int seconds = totalSeconds % 60;               // sisa detik terakhir

            // %02d memastikan format 2 digit dengan angka 0 di depan jika perlu
            String hasil = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            System.out.println("Hasil: " + hasil);

        } else if (pilihan == 2) {
            // Konversi format menjadi total detik
            System.out.print("Masukkan waktu (HH:MM:SS): ");
            String waktu = scanner.nextLine().trim();

            // Memisahkan string berdasarkan tanda (simbol)
            String[] parts = waktu.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);

            int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
            System.out.println("Hasil: " + totalSeconds + " detik");

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
    
}
