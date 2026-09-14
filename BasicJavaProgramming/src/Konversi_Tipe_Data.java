/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Konversi_Tipe_Data {

    public static void main(String[] args) {
        // Implicit (otomatis) - dari tipe kecil ke tipe besar
        int myInt = 9;
        double myDouble = myInt; // otomatis
        System.out.println(myDouble);

        // Explicit (manual/narrowing) - dari tipe besar ke tipe kecil
        double myDouble2 = 9.78;
        int myInt2 = (int) myDouble2; // hasil 9, .78 hilang
        System.out.println(myInt2);
    }
}