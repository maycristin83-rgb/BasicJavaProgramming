/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

import java.util.*;

public class StringManipulationMod {
    public static void main(String[] args) {
        String text = " Hello World! Welcome to Java Programming ";
        String trimmedText = text.trim(); // Membersihkan spasi tepi
        
        // --- MODIFIKASI 1: Kata > 4 Karakter ---
        System.out.println("=== KATA DENGAN PANJANG > 4 KARAKTER ===");
        
        // Memecah kalimat berdasarkan spasi (menggunakan \\s+ agar aman dari spasi ganda)
        String[] words = trimmedText.split("\\s+");
        
        for (String word : words) {
            // Menghilangkan tanda baca (seperti tanda seru '!'), agar yang dihitung murni hurufnya saja
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            
            // Mengecek jika panjang kata bersih lebih dari 4 karakter
            if (cleanWord.length() > 4) {
                System.out.println("- " + cleanWord + " (Panjang: " + cleanWord.length() + ")");
            }
        }
        
        // --- MODIFIKASI 2: Menghitung Jumlah Huruf Vokal ---
        System.out.println("\n=== JUMLAH HURUF VOKAL ===");
        int totalVokal = hitungHurufVokal(trimmedText);
        System.out.println("Total huruf vokal: " + totalVokal);
    }
    
    // Method helper terpisah untuk menghitung huruf vokal (a, i, u, e, o)
    public static int hitungHurufVokal(String str) {
        int count = 0;
        // Ubah semua huruf menjadi kecil agar pengecekan huruf kapital/kecil seragam
        String lowerStr = str.toLowerCase(); 
        
        // Perulangan untuk mengecek setiap karakter satu per satu
        for (int i = 0; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            // Jika karakter adalah a, i, u, e, atau o, maka counter bertambah 1
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                count++;
            }
        }
        return count; // Mengembalikan total jumlah huruf vokal
    }
}