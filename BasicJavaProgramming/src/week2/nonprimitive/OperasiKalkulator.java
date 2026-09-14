package week2.nonprimitive;

/**
 * Contoh: Tipe Data Non-Primitive - Array & Interface
 * Slide: "Tipe Data Non-Primitive"
 *
 * - Array: koleksi elemen bertipe sama, diakses via indeks.
 * - Interface: kontrak berisi method tanpa implementasi.
 *   Class yang meng-implement wajib mengisi semua method.
 */
interface Operasi {
    int tambah(int a, int b);
}

class Kalkulator implements Operasi {
    @Override
    public int tambah(int a, int b) {
        return a + b;
    }
}

public class OperasiKalkulator {
    public static void main(String[] args) {
        // Array
        int[] arr = {1, 2, 3};
        double[] arr2 = {1.1, 2.2};
        System.out.println("arr[0] = " + arr[0]);
        System.out.println("arr2[1] = " + arr2[1]);

        // Interface
        Kalkulator kalkulator = new Kalkulator();
        System.out.println("5 + 3 = " + kalkulator.tambah(5, 3));
    }
}
