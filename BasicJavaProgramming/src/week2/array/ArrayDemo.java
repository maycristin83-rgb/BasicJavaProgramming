package week2.array;

/**
 * Contoh: Array dalam Java
 * Slide: "Array dalam Java"
 *
 * - Array adalah wadah untuk menyimpan sekumpulan nilai bertipe sama.
 * - Ukuran array ditentukan saat dibuat dan tidak bisa diubah.
 * - Elemen array diakses dengan indeks mulai dari 0.
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // Deklarasi & membuat array
        int[] anArray;
        anArray = new int[10];

        // Isi nilai
        anArray[0] = 100;
        anArray[1] = 200;

        System.out.println(anArray[0]); // 100
        System.out.println(anArray[1]); // 200

        // Shortcut inisialisasi array
        int[] anArray2 = {100, 200, 300, 400};

        // Akses semua elemen dengan loop (for)
        for (int i = 0; i < anArray2.length; i++) {
            System.out.println("anArray2[" + i + "] = " + anArray2[i]);
        }

        // Akses semua elemen dengan enhanced for (for-each)
        for (int nilai : anArray2) {
            System.out.println("nilai (for-each) = " + nilai);
        }

        System.out.println("Panjang array (length) = " + anArray2.length);
    }
}
