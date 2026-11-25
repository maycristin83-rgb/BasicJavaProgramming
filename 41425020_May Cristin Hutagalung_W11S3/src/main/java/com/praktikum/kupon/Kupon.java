/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.kupon;

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

public class Kupon {

    private String kode;          // kode unik kupon
    private int persentase;       // besar diskon dalam persen (1 sampai 100)
    private int kuota;            // sisa jumlah kupon yang boleh dipakai
    private double minBelanja;    // belanja minimum agar kupon berlaku

    public Kupon(String kode, int persentase, int kuota, double minBelanja) {
        // Validasi kode: tidak boleh null atau kosong
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode tidak boleh kosong");
        }
        // Validasi persentase: harus di antara 1 dan 100 (inklusif)
        if (persentase < 1 || persentase > 100) {
            throw new IllegalArgumentException("Persentase harus 1 sampai 100");
        }
        // Validasi kuota awal: tidak boleh negatif (0 diperbolehkan)
        if (kuota < 0) {
            throw new IllegalArgumentException("Kuota tidak boleh negatif");
        }
        // Validasi belanja minimum: tidak boleh negatif (0 diperbolehkan)
        if (minBelanja < 0) {
            throw new IllegalArgumentException("Minimal belanja tidak boleh negatif");
        }
        this.kode = kode;
        this.persentase = persentase;
        this.kuota = kuota;
        this.minBelanja = minBelanja;
    }

    // Getter: hanya mengembalikan nilai atribut private
    public String getKode() { return kode; }
    public int getPersentase() { return persentase; }
    public int getKuota() { return kuota; }
    public double getMinBelanja() { return minBelanja; }

    /** Memakai satu kupon; gagal jika kuota sudah habis. */
    public void pakai() {
        // Kuota 0 berarti kupon tidak bisa dipakai lagi
        if (kuota <= 0) {
            throw new IllegalStateException("Kuota kupon sudah habis");
        }
        kuota--; // kurangi kuota 1
    }

    /** Menambah kuota; jumlah harus positif dan tidak boleh overflow. */
    public void tambahKuota(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }
        // addExact melempar ArithmeticException jika hasil melebihi batas int
        // (versi awal memakai "kuota += jumlah" dan overflow jadi negatif, lihat CATATAN_BUG.md)
        kuota = Math.addExact(kuota, jumlah);
    }

    /** Menghitung besar diskon = total x persentase / 100. */
    public double hitungDiskon(double total) {
        // Kupon hanya berlaku jika total belanja mencapai batas minimum
        if (total < minBelanja) {
            throw new IllegalArgumentException("Total belanja kurang dari minimal belanja");
        }
        return total * persentase / 100.0;
    }

    /** True jika kuota sudah habis. */
    public boolean isHabis() {
        return kuota == 0;
    }
}