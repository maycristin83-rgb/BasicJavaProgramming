package week2.casting;

/**
 * Contoh: Konversi Tipe Data (Type Casting)
 * Slide: "Konversi Tipe Data"
 *
 * 1. Implicit (widening) -> tipe kecil ke tipe besar, otomatis, aman.
 * 2. Explicit (narrowing) -> tipe besar ke tipe kecil, manual, berisiko kehilangan data.
 */
public class KonversiTipeDataDemo {
    public static void main(String[] args) {
        // 1. Implicit casting (otomatis)
        int myInt = 9;
        double myDouble = myInt; // otomatis
        System.out.println("Implicit: int " + myInt + " -> double " + myDouble);

        // 2. Explicit casting (manual)
        double myDouble2 = 9.78;
        int myInt2 = (int) myDouble2; // hasil 9, .78 hilang
        System.out.println("Explicit: double " + myDouble2 + " -> int " + myInt2);
    }
}
