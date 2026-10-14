/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/


import java.util.*;

public class Mantra {

    // Method ucapkan() dengan satu parameter
    public void ucapkan(String namaMantra) {
        System.out.println("Mengucapkan mantra: " + namaMantra);
    }

    // Overload: method ucapkan() dengan dua parameter (nama + kekuatan)
    public void ucapkan(String namaMantra, int kekuatan) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: Senjata terlepas.");
        }
    }

    // Overload (instruksi no. 2): nama mantra + target, tanpa parameter kekuatan
    public void ucapkan(String namaMantra, String target) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " pada " + target);
        System.out.println("Efek: Senjata " + target + " terlepas.");
    }

    // Overload (pertanyaan no. 2): urutan parameter dibalik, signature tetap berbeda
    public void ucapkan(int kekuatan, String namaMantra) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: Senjata terlepas.");
        }
    }

    // Overload: method ucapkan() dengan tiga parameter
    public void ucapkan(String namaMantra, int kekuatan, String target) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan + " pada " + target);
        if (kekuatan > 10) {
            System.out.println("Efek: " + target + " terlempar!");
        } else {
            System.out.println("Efek: Senjata " + target + " terlepas.");
        }
    }
    
    // Tambahkan kelas RonWeasley yang mewarisi Penyihir dan override
    // method ucapkanMantra() dengan implementasi yang sesuai untuk Ron.//

    // Subclass BARU: Ron Weasley mewarisi Penyihir dan meng-override ucapkanMantra()
    class RonWeasley extends Penyihir {
        @Override
        public void ucapkanMantra() {
            System.out.println("Ron Weasley mengucapkan mantra dengan gugup, tetapi tetap berani.");
    }
}

    public static void main(String[] args) {
        // Mmebuat Objek  menggunakan tipe mainabrstrak //
        Mantra mantra = new Mantra();
        mantra.ucapkan("Expelliarmus");                 // 1 parameter
        mantra.ucapkan("Expelliarmus", 5);              // 2 parameter (String, int)
        mantra.ucapkan("Expelliarmus", 15, "Voldemort"); // 3 parameter
        mantra.ucapkan("Expelliarmus", "Voldemort");    // 2 parameter (String, String)
        mantra.ucapkan(12, "Expelliarmus");             // urutan terbalik (int, String)
    }
}

/* Pertanyaan:
1.Apa yang terjadi jika kita tidak menggunakan annotation @Override? Apakah kode masih berjalan? //
Jawab : Ya Kode tetap berjalan dan output keluaran nya itu sama,karena Overriding itu
mempunyai method di sub class memiliki nama dan paramater yang sama. Ovveride itu sebagai penanda
untuk compailer

2.Apa keuntungan menggunakan polymorphism dalam contoh ini? //
Jawab : Polymorphis, itu memiliki satu tipe untuk banyak objel
Varibel nya itu dapat berupa penyihir dan bisa menampung arryPotter, Hermione, 
atau RonWeasley, dan method yang dijalankan menyesuaikan objek aslinya saat runtime.
*/