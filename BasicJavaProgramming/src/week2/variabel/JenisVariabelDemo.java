package week2.variabel;

/**
 * Contoh: Jenis Variabel
 * Slide: "Jenis Variabel"
 *
 * 1. Instance Variables (Non-Static Fields) -> milik setiap object
 * 2. Class Variables (Static Fields)        -> hanya 1 salinan untuk semua objek
 * 3. Local Variables                        -> dideklarasikan di dalam method
 * 4. Parameters                             -> variabel input method/constructor
 */
public class JenisVariabelDemo {

    // 1. Instance variable -> tiap objek punya nilai sendiri
    int speed;

    // 2. Class variable (static) -> hanya 1 salinan untuk semua objek
    static int jumlahMahasiswa;

    // 4. Parameter contoh
    private String nama;

    void setNama(String nama) { // "nama" di sini adalah parameter
        this.nama = nama;
    }

    // 3. Local variable contoh
    void hitung() {
        int count = 0; // local variable, hanya bisa diakses dalam method ini
        count++;
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        JenisVariabelDemo obj1 = new JenisVariabelDemo();
        JenisVariabelDemo obj2 = new JenisVariabelDemo();

        obj1.speed = 80;
        obj2.speed = 100;
        System.out.println("Speed obj1 (instance variable) = " + obj1.speed);
        System.out.println("Speed obj2 (instance variable) = " + obj2.speed);

        jumlahMahasiswa = 40; // class variable, dipakai bersama
        System.out.println("Jumlah Mahasiswa (static) = " + jumlahMahasiswa);

        obj1.setNama("Budi");
        System.out.println("Nama (dari parameter) = " + obj1.nama);

        obj1.hitung();
    }
}
