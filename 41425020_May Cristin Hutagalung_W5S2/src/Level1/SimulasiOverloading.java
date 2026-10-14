/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level1;

/**
 *
 * @author MyBook Hype AMD
 */

/* Nim      : 41425020
   Nama     : May Cristin Hutagalung
   Prodi    : DIV-Teknologi Rekayasa Perangkat Lunak
*/

// Class mesin tarif: satu nama method (hitungOngkir) dengan tiga versi parameter
class MesinTarif {
    private String kotaAsal;   // atribut private (encapsulation)

    public MesinTarif(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    // Versi 1: ongkir dasar berdasarkan berat
    public double hitungOngkir(double beratKg) {
        return beratKg * 10000;
    }

    // Versi 2: ongkir + asuransi 1% dari nilai barang
    public double hitungOngkir(double beratKg, double nilaiBarang) {
        double biayaAsuransi = nilaiBarang * 0.01;
        return (beratKg * 10000) + biayaAsuransi;
    }

    // Versi 3: ongkir express, tambah Rp20.000 jika isExpress true
    public double hitungOngkir(double beratKg, boolean isExpress) {
        double total = beratKg * 10000;
        if (isExpress) {
            total += 20000;
        }
        return total;
    }
}

public class SimulasiOverloading {
    public static void main(String[] args) {
        MesinTarif tarif = new MesinTarif("Medan");

        System.out.println("=== INI METHOD OVERLOADING ===");
        // Compiler memilih versi method dari jumlah dan tipe argumen
        System.out.println("Ongkir Biasa (2.0 Kg)         : Rp " + tarif.hitungOngkir(2.0));
        System.out.println("Ongkir + Asuransi (Barang 5Jt): Rp " + tarif.hitungOngkir(2.0, 5000000.0));
        System.out.println("Ongkir Express (2.0 Kg)       : Rp " + tarif.hitungOngkir(2.0, true));
    }
}

/* Analisis Overloading
1.Mengapa compiler Java dapat menentukan method hitungOngkir mana yang dijalankan
sebelum program dieksekusi (compile-time)? Bagian method apa yang diperiksa compiler?

Jawab : Kompiler Java dapat menentukan metode hitungOngkir mana yang akan 
dipanggil, sebelum program berjalan, karena overloading menentukan metode 
mana yang dipanggil, berdasarkan parameter dan argumen dari metode tersebut, 
dan pada overloading, sebuah metode tidak ditentukan oleh nilai parameter, 
tetapi oleh tipe parameter. Semua informasi ini pasti selama kompilasi, 
oleh karena itu kompilator tidak perlu menunggu hingga program berjalan.
Method yang diperiksa compiler adalah hitungOngkir

2.Jika pada class MesinTarif ditambahkan method berikut:
public int hitungOngkir(double beratKg) {
return (int)(beratKg * 10000);
}
Mengapa compiler menolak kode tersebut padahal tipe kembaliannya berbeda (int vs double)?

Jawab : Compiler menolak kode tersebut karena return type bukan bagian 
dari signature method. Signature hanya terdiri dari nama method dan daftar 
parameternya (jumlah, tipe, dan urutannya
*/