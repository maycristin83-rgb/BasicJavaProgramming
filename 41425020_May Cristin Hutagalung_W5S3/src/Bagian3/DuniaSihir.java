/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian3;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim   : 41425020
  Nama  : May Cristin Hutagalung
  Prodi : DIV-Teknologi Rekayasa Perangkat Lunak
*/

import java.util.*;

// Abstract class: kerangka dasar semua mantra
abstract class Mantra {
    private String nama; // nama mantra

    public Mantra(String nama) {
        this.nama = nama;
    }

    // Getter agar nama bisa dibaca dari luar kelas
    public String getNama() {
        return nama;
    }

    // Abstract method untuk efek mantra (wajib diimplementasikan subclass)
    public abstract void efek();
}

// Mantra konkret 1
class Expelliarmus extends Mantra {
    public Expelliarmus() {
        super("Expelliarmus");
    }

    @Override
    public void efek() {
        System.out.println("Melucuti senjata lawan!");
    }
}

// Mantra konkret 2
class ExpectoPatronum extends Mantra {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }

    @Override
    public void efek() {
        System.out.println("Memanggil Patronus!");
    }
}

// Mantra konkret 3
class Lumos extends Mantra {
    public Lumos() {
        super("Lumos");
    }

    @Override
    public void efek() {
        System.out.println("Menerangi ujung tongkat!");
    }
}

class Penyihir {
    private String nama;
    private List<Mantra> mantraList; // daftar mantra yang sudah dipelajari

    public Penyihir(String nama) {
        this.nama = nama;
        this.mantraList = new ArrayList<>();
    }

    // Menambahkan mantra ke daftar (polymorphism: menerima semua jenis Mantra)
    public void belajarMantra(Mantra mantra) {
        mantraList.add(mantra);
        System.out.println(nama + " belajar mantra: " + mantra.getNama());
    }

    // Mengucapkan satu mantra berdasarkan nama
    public void ucapkanMantra(String namaMantra) {
        for (Mantra mantra : mantraList) {
            if (mantra.getNama().equals(namaMantra)) {
                System.out.println(nama + " mengucapkan: " + mantra.getNama());
                mantra.efek(); // efek yang jalan sesuai jenis mantra aslinya
                return;
            }
        }
        System.out.println(nama + " belum belajar mantra " + namaMantra);
    }

    // TAMBAHAN 1: mengucapkan semua mantra yang sudah dipelajari dalam satu perintah
    public void ucapkanSemuaMantra() {
        if (mantraList.isEmpty()) {
            System.out.println(nama + " belum mempelajari mantra apa pun.");
            return;
        }
        for (Mantra mantra : mantraList) {
            System.out.println(nama + " mengucapkan: " + mantra.getNama());
            mantra.efek(); // polymorphism: efek berbeda untuk tiap mantra
        }
    }
}

public class DuniaSihir {
    public static void main(String[] args) {
        Penyihir harry = new Penyihir("Harry Potter");
        Mantra expelliarmus = new Expelliarmus();
        Mantra expectoPatronum = new ExpectoPatronum();

        harry.belajarMantra(expelliarmus);
        harry.belajarMantra(expectoPatronum);

        harry.ucapkanMantra("Expelliarmus");
        harry.ucapkanMantra("Expecto Patronum");
        harry.ucapkanMantra("Lumos"); // Harry belum belajar Lumos

        // Tambahkan mantra Lumos dan coba lagi
        Mantra lumos = new Lumos();
        harry.belajarMantra(lumos);
        harry.ucapkanMantra("Lumos");

        // TAMBAHAN 2: ucapkan semua mantra sekaligus
        System.out.println("\n--- Mengucapkan semua mantra ---");
        harry.ucapkanSemuaMantra();
    }
}