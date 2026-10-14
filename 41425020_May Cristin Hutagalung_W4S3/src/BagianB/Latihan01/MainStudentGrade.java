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

public class MainStudentGrade {
    public static void main(String[] args) {
        StudentGrade mhs = new StudentGrade("11425001", "Marsha");

        mhs.setNilaiKuis(110.0);   // ditolak: di luar rentang
        mhs.setNilaiKuis(85.0);    // berhasil
        mhs.setNilaiUts(90.0);     // berhasil

        // mhs.gradeHuruf = "A";   // ERROR kompilasi: private, tidak bisa di-set langsung
        // mhs.setNim("123");      // ERROR kompilasi: setter NIM memang tidak ada

        mhs.cetakLaporan();
    }
}
