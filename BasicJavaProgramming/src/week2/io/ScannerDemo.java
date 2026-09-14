package week2.io;

import java.util.Scanner;

/**
 * Contoh: Input/Output (Scanner)
 * Slide: "Input/Output (Scanner)"
 *
 * Scanner membaca input yang diformat dan mengubahnya menjadi bentuk biner.
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        System.out.println("Halo, " + nama);
        sc.close();
    }
}
