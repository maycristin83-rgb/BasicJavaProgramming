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


public class CreditCardValidator {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor kartu: ");
        String input = scanner.nextLine().trim();

        // Jika format menggunakan tanda hubung, pastikan polanya benar dulu:
        // 4 kelompok digit, masing-masing 4 digit, dipisah tanda hubung.
        if (input.contains("-")) {
            String[] groups = input.split("-");
            boolean formatHubungValid = groups.length == 4;

            if (formatHubungValid) {
                for (String g : groups) {
                    // setiap kelompok harus tepat 4 digit angka
                    if (g.length() != 4 || !g.chars()
                            .allMatch(Character::isDigit)) {
                        formatHubungValid = false;
                        break;
                    }
                }
            }

            if (!formatHubungValid) {
                System.out.println("Nomor kartu tidak valid!");
                System.out.println("Format tanda hubung harus berupa 4 "
                        + "kelompok @4 digit, contoh: 4123-4567-8901-2345.");
                scanner.close();
                return;
            }
        }

        // Menghilangkan semua tanda hubung untuk memudahkan validasi digit
        String digitsOnly = input.replace("-", "");

        // Validasi semua karakter harus digit (angka)
        boolean isAllDigit = digitsOnly.chars().allMatch(Character::isDigit);
        if (!isAllDigit) {
            System.out.println("Nomor kartu tidak valid!");
            System.out.println("Hanya boleh berisi angka dan tanda hubung.");
            scanner.close();
            return;
        }

        // Validasi yang harus tepat 16 digit
        if (digitsOnly.length() != 16) {
            System.out.println("Nomor kartu tidak valid!");
            System.out.println("Harus terdiri dari 16 digit.");
            scanner.close();
            return;
        }

        // Validasiyang harus dimulai dengan 4, 5, atau 6
        char firstDigit = digitsOnly.charAt(0);
        if (firstDigit != '4' && firstDigit != '5' && firstDigit != '6') {
            System.out.println("Nomor kartu tidak valid!");
            System.out.println("Harus dimulai dengan 4, 5, atau 6.");
            scanner.close();
            return;
        }

        // Dapat memvalidasi Semua validasi lolos
        System.out.println("Nomor kartu valid.");

        scanner.close();
    }
    
}
