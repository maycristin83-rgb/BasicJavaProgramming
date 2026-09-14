package week2.variabel;

/**
 * Contoh: Penamaan Variabel
 * Slide: "Penamaan Variabel"
 *
 * Aturan & konvensi:
 * - Case-sensitive
 * - Nama harus mulai dengan huruf
 * - Hindari $ dan _
 * - Tidak boleh pakai keyword Java
 * - Gunakan nama yang jelas (camelCase untuk variabel, UPPER_CASE untuk konstanta)
 */
public class PenamaanVariabelDemo {

    static final double PI = 3.14159; // konstanta -> UPPER_CASE

    public static void main(String[] args) {
        int umur = 20;
        double gaji = 3500000.50;
        boolean lulus = true;
        String nama = "Budi";

        System.out.println("Umur  : " + umur);
        System.out.println("Gaji  : " + gaji);
        System.out.println("Lulus : " + lulus);
        System.out.println("Nama  : " + nama);
        System.out.println("PI (konstanta) : " + PI);
    }
}
