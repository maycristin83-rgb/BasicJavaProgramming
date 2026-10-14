/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tantangan;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim   : 41425020
  Nama  : May Cristin Hutagalung
  Prodi : DIV-Teknologi Rekayasa Perangkat Lunak
*/

import java.util.*;

// 1. Abstract class: kontrak untuk semua mantra perlindungan
abstract class MantraPerlindungan {
    protected String nama;          // nama mantra
    protected boolean aktif = false; // status mantra (aktif / tidak)

    public MantraPerlindungan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public boolean isAktif() {
        return aktif;
    }

    // Abstract method: wajib diimplementasikan semua subclass
    public abstract void aktifkan();
    public abstract void nonaktifkan();
}

// 2a. Protego: perisai pelindung
class Protego extends MantraPerlindungan {
    public Protego() {
        super("Protego");
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Perisai Protego terbentuk!");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Perisai Protego menghilang.");
    }
}

// 2b. Fidelius: membutuhkan penyihir sebagai secret keeper
class Fidelius extends MantraPerlindungan {
    private String secretKeeper; // penyihir penjaga rahasia

    public Fidelius(String secretKeeper) {
        super("Fidelius");
        this.secretKeeper = secretKeeper;
    }

    @Override
    public void aktifkan() {
        // Fidelius hanya bisa aktif jika ada secret keeper
        if (secretKeeper == null || secretKeeper.isEmpty()) {
            System.out.println("Fidelius gagal diaktifkan: butuh secret keeper!");
            return;
        }
        aktif = true;
        System.out.println("Fidelius aktif. Rahasia dijaga oleh " + secretKeeper + ".");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Fidelius dinonaktifkan. Rahasia tidak lagi terlindungi.");
    }
}

// 2c. Mantra anti-apparition: mencegah apparition di area tertentu
class MantraAntiApparition extends MantraPerlindungan {
    private String area; // area yang dilindungi

    public MantraAntiApparition(String area) {
        super("Anti-Apparition");
        this.area = area;
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Apparition dicegah di area: " + area);
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Apparition kembali diizinkan di area: " + area);
    }
}

// 3. Sistem pertahanan: menampung banyak mantra perlindungan
class SistemPertahanan {
    private List<MantraPerlindungan> daftarMantra = new ArrayList<>();

    // Menambahkan mantra ke sistem (menerima semua jenis MantraPerlindungan)
    public void tambahMantra(MantraPerlindungan mantra) {
        daftarMantra.add(mantra);
        System.out.println(mantra.getNama() + " ditambahkan ke sistem pertahanan.");
    }

    // Mengaktifkan semua mantra (polymorphism: aktifkan() sesuai jenis mantra)
    public void aktifkanSemuaMantra() {
        for (MantraPerlindungan m : daftarMantra) {
            m.aktifkan();
        }
    }

    // Menonaktifkan semua mantra
    public void nonaktifkanSemuaMantra() {
        for (MantraPerlindungan m : daftarMantra) {
            m.nonaktifkan();
        }
    }
}

// 4. Demonstrasi
public class SistemPertahananHogwarts {
    public static void main(String[] args) {
        SistemPertahanan hogwarts = new SistemPertahanan();

        // Membuat beberapa objek mantra
        MantraPerlindungan protego = new Protego();
        MantraPerlindungan fidelius = new Fidelius("Severus Snape");
        MantraPerlindungan antiApparition = new MantraAntiApparition("Kastil Hogwarts");

        // Menambahkan ke sistem pertahanan
        hogwarts.tambahMantra(protego);
        hogwarts.tambahMantra(fidelius);
        hogwarts.tambahMantra(antiApparition);

        System.out.println("\n--- Mengaktifkan semua mantra ---");
        hogwarts.aktifkanSemuaMantra();

        System.out.println("\n--- Menonaktifkan semua mantra ---");
        hogwarts.nonaktifkanSemuaMantra();
    }
}