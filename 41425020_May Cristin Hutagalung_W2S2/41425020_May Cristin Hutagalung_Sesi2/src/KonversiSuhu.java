/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;

public class KonversiSuhu {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        // --- Konversi Celsius ke Fahrenheit ---
        System.out.print("Masukkan suhu dalam Celsius: ");
        double celsius = input.nextDouble();
 
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " C = " + fahrenheit + " F");
 
        // --- Konversi Fahrenheit ke Celsius ---
        System.out.print("Masukkan suhu dalam Fahrenheit: ");
        double fahrenheit2 = input.nextDouble();
 
        double celsius2 = (fahrenheit2 - 32) * 5 / 9;
        // Membulatkan hasil ke 2 angka desimal menggunakan printf
        System.out.printf("%.1f F = %.2f C%n", fahrenheit2, celsius2);
 
        input.close();
    }
}
