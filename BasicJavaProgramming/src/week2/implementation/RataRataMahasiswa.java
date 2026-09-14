package week2.implementation;

/**
 * Contoh: Simple Implementation
 * Slide: "Simple Implementation"
 *
 * Menghitung nilai rata-rata mahasiswa:
 * - Gunakan enhanced for loop (for-each) untuk array agar lebih ringkas.
 * - Casting ke double untuk menghindari pembagian integer.
 */
public class RataRataMahasiswa {
    public static void main(String[] args) {
        int[] nilai = {80, 90, 75, 88};
        int total = 0;
        for (int n : nilai) { // enhanced for loop
            total += n;
        }
        double rata = (double) total / nilai.length;
        System.out.println("Rata-rata = " + rata);
    }
}
