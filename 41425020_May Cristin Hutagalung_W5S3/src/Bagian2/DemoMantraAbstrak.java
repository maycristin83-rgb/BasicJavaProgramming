/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian2;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

import java.util .*;

abstract class MantraAbstrak {
    private String nama;
    public MantraAbstrak(String nama) {
        this.nama = nama;
    }
    // Abstract method: harus diimplementasikan oleh subclass
    public abstract void efek();

    // Method konkret
    public void ucapkan() {
        System.out.println("Mengucapkan mantra: " + nama);
    }
}

class Expelliarmus extends MantraAbstrak {
    public Expelliarmus() {
        super("Expelliarmus");
    }
    @Override
    public void efek() {
        System.out.println("Efek: Melucuti senjata lawan.");
    }
}

class ExpectoPatronum extends MantraAbstrak {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }
    @Override
    public void efek() {
        System.out.println("Efek: Memanggil Patronus untuk melawan Dementor.");
    }
}

// Tambahkan mantra baru, misalnya Lumos yang mewarisi MantraAbstrak dan
// implementasikan method efek().//
    class Lumos extends MantraAbstrak {
        public Lumos() {
            super("Lumos"); // kirim nama mantra ke constructor induk
        }
        
            @Override
        public void efek() {
            System.out.println("Efek: Menerangi ujung tongkat.");
        }
    }
    
public class DemoMantraAbstrak {
    public static void main(String[] args) {
        MantraAbstrak mantra1 = new Expelliarmus();
        MantraAbstrak mantra2 = new ExpectoPatronum();
        MantraAbstrak mantra3 = new Lumos();
        
        mantra1.ucapkan();
        mantra1.efek();
        
        mantra2.ucapkan();
        mantra2.efek();
        
        mantra3.ucapkan();
        mantra3.efek();
    }
}

 /* Pertanyaan 
1.Apa yang terjadi jika kita mencoba membuat objek dari MantraAbstrak langsung? Coba dan jelaskan errornya.
Jawab : Membuat objek MantraAbstrak langsung menyebabkan error
MantraAbstrak is abstract; cannot be instantiated", karena abstract class
belum lengkap (punya method abstract efek() tanpa isi).
2.Mengapa kita perlu membuat abstract class? Apa keuntungannya?
Jawab : Abstract class diperlukan untuk memaksa semua subclass mengimplementasikan
Efek(), berbagi kode umum, dan mendukung polymorphism.
*/