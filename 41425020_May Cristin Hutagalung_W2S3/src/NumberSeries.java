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

public class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah deret Fibonacci: ");
        int n = scanner.nextInt();

        // Generate deret Fibonacci
        System.out.println("Deret Fibonacci:");
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b; // suku berikutnya = jumlah dua suku sebelumnya
            a = b;
            b = next;
        }
        System.out.println();

        // Cek bilangan prima
        System.out.print("Masukkan bilangan untuk dicek prima: ");
        int num = scanner.nextInt();
        boolean isPrime = true;

        if (num <= 1) {
            // Bilangan kurang dari atau sama dengan 1 bukan bilangan prima
            isPrime = false;
        } else {
            // Cek pembagi dari 2 sampai akar kuadrat dari num
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; // ditemukan pembagi selain 1 dan num sendiri
                    break;
                }
            }
        }

        System.out.println(num + (isPrime ? " adalah bilangan prima" : " bukan bilangan prima"));

        scanner.close();
    }
}
