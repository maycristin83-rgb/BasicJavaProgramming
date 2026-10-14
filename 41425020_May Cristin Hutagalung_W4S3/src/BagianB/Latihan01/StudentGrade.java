/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BagianB.Latihan01;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

public class StudentGrade {
    // NIM dan nama: final + tanpa setter -> read-only
    private final String nim;
    private final String nama;

    // Nilai: hanya bisa diubah lewat setter yang memvalidasi
    private double nilaiKuis;
    private double nilaiUts;

    // Read-only: hanya punya getter, dihitung otomatis oleh method private
    private String gradeHuruf;

    public StudentGrade(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiKuis = 0.0;
        this.nilaiUts = 0.0;
        hitungGradeHuruf();   // inisialisasi grade awal
        System.out.println("[Registrasi] Berhasil mendaftarkan mahasiswa: " + nim + " - " + nama);
    }

    // Getter read-only (tidak ada setNim / setNama)
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public double getNilaiKuis() { return nilaiKuis; }
    public double getNilaiUts() { return nilaiUts; }
    public String getGradeHuruf() { return gradeHuruf; }

    // Setter kuis: tolak jika di luar rentang 0.0 - 100.0
    public void setNilaiKuis(double nilaiKuis) {
        if (nilaiKuis < 0.0 || nilaiKuis > 100.0) {
            System.out.println("[Error] Nilai kuis tidak valid: " + nilaiKuis
                    + " (Harus antara 0 - 100)");
            return;   // perubahan ditolak
        }
        this.nilaiKuis = nilaiKuis;
        System.out.println("[Update] Nilai kuis berhasil diubah menjadi: " + nilaiKuis);
        hitungGradeHuruf();   // grade diperbarui otomatis
    }

    // Setter UTS: validasi sama dengan kuis
    public void setNilaiUts(double nilaiUts) {
        if (nilaiUts < 0.0 || nilaiUts > 100.0) {
            System.out.println("[Error] Nilai UTS tidak valid: " + nilaiUts
                    + " (Harus antara 0 - 100)");
            return;
        }
        this.nilaiUts = nilaiUts;
        System.out.println("[Update] Nilai UTS berhasil diubah menjadi: " + nilaiUts);
        hitungGradeHuruf();
    }

    // Nilai akhir = 40% kuis + 60% UTS
    public double hitungNilaiAkhir() {
        return (0.4 * nilaiKuis) + (0.6 * nilaiUts);
    }

    // Method private: hanya dipanggil internal oleh setter yang berhasil
    private void hitungGradeHuruf() {
        double akhir = hitungNilaiAkhir();
        if (akhir >= 85) {
            gradeHuruf = "A";
        } else if (akhir >= 70) {
            gradeHuruf = "B";
        } else if (akhir >= 55) {
            gradeHuruf = "C";
        } else if (akhir >= 40) {
            gradeHuruf = "D";
        } else {
            gradeHuruf = "E";
        }
    }

    // Cetak laporan hasil studi
    public void cetakLaporan() {
        System.out.println("=== KARTU HASIL STUDI ===");
        System.out.println("NIM        : " + nim);
        System.out.println("Nama       : " + nama);
        System.out.println("Nilai Kuis : " + nilaiKuis);
        System.out.println("Nilai UTS  : " + nilaiUts);
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
        System.out.println("Grade      : " + gradeHuruf);
    }
}
