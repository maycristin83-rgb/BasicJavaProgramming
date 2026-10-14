/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level1;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

// Parent class:  yang berperilaku sebagai kurir standar (jalur darat)
class KurirReguler {
    protected String nama;

    public KurirReguler(String nama) {
        this.nama = nama;
    }

    public void kirimBarang(String alamat) {
        System.out.println(nama + " mengantar paket ke " + alamat
                + " lewat jalur darat menembus kemacetan.");
    }
}

// Child class: kurir drone meng-override kirimBarang
class KurirDrone extends KurirReguler {
    private String idDrone;

    public KurirDrone(String nama, String idDrone) {
        super(nama);              // panggil constructor parent
        this.idDrone = idDrone;
    }

    @Override                     // memastikan benar-benar meng-override
    public void kirimBarang(String alamat) {
        System.out.println("Unit Drone [" + idDrone + "] operator " + nama
                + " terbang mengantar paket langsung ke koordinat: " + alamat);
    }
}

public class SimulasiOverriding {
    public static void main(String[] args) {
        System.out.println("=== INI METHOD OVERRIDING ===");

        KurirReguler k1 = new KurirReguler("Budi");
        KurirReguler k2 = new KurirDrone("Arka", "DRN-01");   // referensi parent, objek child

        k1.kirimBarang("Jl. Sudirman No. 10");
        k2.kirimBarang("Gedung Graha Lt. 5");   // yang jalan: versi KurirDrone (runtime)
    }
}

/*
Analisis Overriding :
1.Pada class KurirDrone, hapus atau jadikan komentar baris @Override. Kemudian, ubah nama
method di bawahnya secara sengaja menjadi salah ketik, misalnya: public void
kirimbarang(String alamat) (menggunakan huruf 'b' kecil).

Jawab : Program dapat dikompilasi dan dijalankan, tetapi output k2.kirimBarang
("Gedung Graha Lt. 5") berubah menjadi versi parent class, yaitu jalur darat:
Arka mengantar paket ke Gedung Graha Lt. 5 lewat jalur darat menembus kemacetan.

2.Jalankan SimulasiOverriding.java. Apa output yang tercetak dari k2.kirimBarang("Gedung
Graha Lt. 5")? Apakah masih "lewat jalur udara" atau berubah menjadi "lewat jalur darat"?

Jawab : Program dapat dikompilasi dan dijalankan, tetapi output k2.kirimBarang
("Gedung Graha Lt. 5") berubah menjadi versi parent class, yaitu jalur darat:
Arka mengantar paket ke Gedung Graha Lt. 5 lewat jalur darat menembus kemacetan.

3.Sekarang kembalikan tulisan @Override di atas method yang salah ketik tersebut, lalu kompilasi
ulang. Salin pesan error yang muncul!

Jawab : method does not override or implement a method from a supertype
----
(Alt-Enter shows hints)

Pesan error setelah @Override dikembalikan
4.Berdasarkan eksperimen di atas, jelaskan dengan bahasa Anda sendiri apa fungsi utama dari tulisan
@Override bagi seorang programmer!
Jawab : @Override memberi tahu compiler bahwa metode di bawahnya dimaksudkan 
untuk mengoverride suatu metode di kelas induk. Karena hal ini, compiler 
memeriksa apakah kelas induk memiliki suatu metode dengan nama dan parameter 
yang sama dengan metode yang memiliki anotasi @Override.
*/