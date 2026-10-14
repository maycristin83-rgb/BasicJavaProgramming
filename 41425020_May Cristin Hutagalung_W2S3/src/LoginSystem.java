/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*  Nim     : 41425020
    Nama    : May Cristin Hutagalung
*/
/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;
        
public class LoginSystem {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kredensial acuan yang dianggap benar
        final String VALID_USERNAME = "admin";
        final String VALID_PASSWORD = "password123";

        int maxAttempt = 3;
        boolean loggedIn = false;

        System.out.println("=== Sistem Login ===");

        for (int attempt = 1; attempt <= maxAttempt; attempt++) {
            System.out.println("Percobaan " + attempt + ":");

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Validasi panjang username (5-10 karakter)
            if (username.length() < 5 || username.length() > 10) {
                System.out.println("Login gagal! Username harus antara 5-10 karakter.");
                continue; // lanjut ke percobaan berikutnya
            }

            // Validasi password: minimal 8 karakter dan mengandung minimal satu angka
            boolean containsDigit = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    containsDigit = true;
                    break;
                }
            }

            if (password.length() < 8 || !containsDigit) {
                System.out.println("Login gagal! Password harus minimal 8 karakter dan mengandung angka.");
                continue;
            }

            // Format username & password sudah valid, cek kecocokan dengan akun acuan
            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                System.out.println("Login berhasil!");
                loggedIn = true;
                break; // keluar dari perulangan karena login sukses
            } else if (username.equals(VALID_USERNAME)) {
                // Username benar tapi password salah
                System.out.println("Login gagal! Password salah.");
            } else {
                // Username tidak dikenali
                System.out.println("Login gagal! Username tidak ditemukan.");
            }
        }

        // Jika sampai akhir perulangan belum berhasil login, akun terkunci
        if (!loggedIn) {
            System.out.println("Akun terkunci! Terlalu banyak percobaan gagal.");
        }

        scanner.close();
    }
    
}

// Pertanyaan Pemantik :
//- Bagaimana cara mengoptimalkan algoritma Fibonacci untuk jumlah yang besar?
// Jawab : Untuk menghindari pendekatan rekrusi menggunakan tipe data besar 
// seperti BigInteger (dalam Java/C#) karena angka Fibonacci tumbuh sangat 
// cepat dan akan mengalami overflow pada tipe data primitif seperti long 
// atau int.