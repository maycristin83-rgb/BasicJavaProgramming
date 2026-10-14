/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author MyBook Hype AMD
 */

//Nim   :   41425020
//Nama  :   May Cristin Hutagalung
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak

class Mahasiswa {
    String nama;
    String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

class MahasiswaAktif extends Mahasiswa {
    int semester;

    public MahasiswaAktif(String nama, String nim, int semester) {
        super(nama, nim); // memanggil constructor Mahasiswa
        this.semester = semester;
    }

    public void belajar() {
        System.out.println(nama + " sedang belajar di semester " + semester);
    }
}

public class Main02 {
    public static void main(String[] args) {
        MahasiswaAktif m1 = new MahasiswaAktif("Dina", "123456", 5);
        m1.tampilkanData();
        m1.belajar();
    }
}