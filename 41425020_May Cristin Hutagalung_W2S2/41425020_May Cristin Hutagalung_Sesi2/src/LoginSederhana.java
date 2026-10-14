/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;

public class LoginSederhana {
       public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
 
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        boolean usernameValid = username.equals("admin");
 
        boolean panjangValid = password.length() >= 6;
 
        boolean mengandungAngka = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                mengandungAngka = true;
                break; // sudah ketemu angka, tidak perlu lanjut looping
            }
        }

        boolean passwordValid = panjangValid && mengandungAngka;

        if (!usernameValid) {
            System.out.println("Login gagal! Username tidak ditemukan.");
        } else if (!passwordValid) {
            System.out.println("Login gagal! Password tidak valid.");
        } else {
            System.out.println("Login berhasil!");
        }
 
        input.close();
    } 
}
