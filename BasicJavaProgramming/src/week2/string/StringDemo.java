package week2.string;

/**
 * Contoh: String dalam Java
 * Slide: "String dalam Java"
 *
 * - String adalah objek, bukan primitive.
 * - Bisa dibandingkan dengan .equals() (bukan ==).
 *   equals() untuk cek isi string, == hanya cek referensi (alamat memori).
 */
public class StringDemo {
    public static void main(String[] args) {
        String nama = "Budi";

        System.out.println(nama.length());          // 4
        System.out.println(nama.toUpperCase());      // "BUDI"
        System.out.println(nama.equals("Budi"));      // true

        String nama2 = new String("Budi");
        System.out.println(nama == nama2);            // false (beda referensi)
        System.out.println(nama.equals(nama2));        // true  (isi sama)
    }
}
