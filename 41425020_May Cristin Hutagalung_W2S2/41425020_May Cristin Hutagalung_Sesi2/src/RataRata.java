/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;

public class RataRata {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        // Input 3 nilai ujian menggunakan tipe double agar hasil rata-rata
        // bisa memiliki angka desimal
        System.out.print("Masukkan nilai 1: ");
        double nilai1 = input.nextDouble();

        System.out.print("Masukkan nilai 2: ");
        double nilai2 = input.nextDouble();

        System.out.print("Masukkan nilai 3: ");
        double nilai3 = input.nextDouble();

        // Menghitung rata-rata: jumlah semua nilai dibagi banyaknya nilai
        double rataRata = (nilai1 + nilai2 + nilai3) / 3;

        // Menampilkan hasil rata-rata dengan format 2 angka di belakang koma
        System.out.printf("Rata-rata: %.2f%n", rataRata);

        input.close();
    }
}

