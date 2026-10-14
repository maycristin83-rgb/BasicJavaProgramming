/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;

public class PalindromeVokal {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan kata: ");
        String kata = input.nextLine();

        // Ubah ke huruf kecil semua agar pengecekan tidak case-sensitive
        // (misal "Katak" dan "katak" dianggap sama)
        String kataLower = kata.toLowerCase();

        // Hapus spasi agar frasa seperti "i love vi" tetap bisa dicek
        // (opsional, tergantung kebutuhan; di sini kita hapus spasi)
        String kataBersih = kataLower.replace(" ", "");

        // ---- Cek Palindrome ----
        // Balik string menggunakan StringBuilder
        String kataBalik = new StringBuilder(kataBersih).reverse().toString();

        // Bandingkan string asli (bersih) dengan string yang sudah dibalik
        boolean isPalindrome = kataBersih.equals(kataBalik);

        if (isPalindrome) {
            System.out.println("\"" + kata + "\" adalah PALINDROME.");
        } else {
            System.out.println("\"" + kata + "\" BUKAN palindrome.");
        }

        // ---- Hitung Jumlah Huruf Vokal ----
        int jumlahVokal = 0;

        // Looping setiap karakter dalam kata, cek apakah termasuk huruf vokal
        for (int i = 0; i < kataBersih.length(); i++) {
            char c = kataBersih.charAt(i);
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                jumlahVokal++;
            }
        }

        System.out.println("Jumlah huruf vokal: " + jumlahVokal);

        input.close();
    }
}
