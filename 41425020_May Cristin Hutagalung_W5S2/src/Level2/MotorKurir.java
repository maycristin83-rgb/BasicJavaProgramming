/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level2;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim   : 41425020
  Nama  : May Cristin Hutagalung
  Prodi : DIV-Teknologi Rekayasa Perangkat Lunak
*/

// MotorKurir setelah diperbaiki: angkutBarang() sudah diimplementasikan
public class MotorKurir extends KendaraanEkspedisi {

    public MotorKurir(String noPolisi, int kapasitasKg) {
        super(noPolisi, kapasitasKg);
    }

    // Implementasi method abstract dari parent
    @Override
    public void angkutBarang(String namaBarang) {
        System.out.println("Motor Kurir [" + noPolisi + "] membawa '" + namaBarang
                + "' di box belakang menembus gang sempit.");
    }
}