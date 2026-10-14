/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */


import java.util.Scanner;

public class Lingkaran_Modifikasi { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PI dideklarasikan sebagai final karena nilainya konstan (tidak berubah)
        final double PI = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        // Validasi: jari-jari tidak boleh negatif (tidak masuk akal secara fisik)
        if (r < 0) {
            System.out.println("Error: jari-jari tidak boleh negatif.");
        } else {
            // Rumus luas lingkaran: PI * r^2
            double luas = PI * r * r;
            // Rumus keliling lingkaran: 2 * PI * r
            double keliling = 2 * PI * r;

            System.out.println("Luas: " + luas);
            System.out.println("Keliling: " + keliling);
        }

        input.close();
    }
}
