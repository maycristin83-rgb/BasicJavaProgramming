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

import java.util.*; // mengimpor package utilitas Java (belum terpakai di program ini)

// Class induk (superclass): menyimpan perilaku umum semua penyihir
class Penyihir {
    // Method dengan perilaku default: cara biasa mengucapkan mantra
    public void ucapkanMantra() {
        System.out.println("Mengucapkan mantra dengan cara biasa.");
    }
}

// Subclass: HarryPotter mewarisi (extends) Penyihir
class HarryPotter extends Penyihir {
    // @Override: menandakan method ini menimpa method ucapkanMantra() milik Penyihir.
    // Compiler akan memberi error jika nama/parameter method tidak cocok dengan induknya.
    @Override
    public void ucapkanMantra() {
        // Implementasi khusus Harry
        System.out.println("Harry Potter mengucapkan mantra dengan tongkatnya yang unik.");
    }
}

// Subclass: Hermione mewarisi (extends) Penyihir
class Hermione extends Penyihir {
    // Override method induk dengan implementasi khusus Hermione
    @Override
    public void ucapkanMantra() {
        System.out.println("Hermione mengucapkan mantra dengan tepat dan percaya diri.");
    }
}

// Class utama yang berisi method main (titik awal program)
public class DemoPenyihir {
    public static void main(String[] args) {
        // POLYMORPHISM: variabel bertipe Penyihir (induk) menampung objek subclass.
        // penyihir1 menunjuk ke objek HarryPotter, penyihir2 ke objek Hermione.
        Penyihir penyihir1 = new HarryPotter();
        Penyihir penyihir2 = new Hermione();

        // Method yang dijalankan ditentukan oleh objek aslinya saat program berjalan (runtime),
        // bukan oleh tipe variabelnya. Jadi yang tampil adalah versi milik Harry dan Hermione.
        penyihir1.ucapkanMantra(); // Output: Harry Potter mengucapkan mantra dengan tongkatnya yang unik.
        penyihir2.ucapkanMantra(); // Output: Hermione mengucapkan mantra dengan tepat dan percaya diri.
    }
}