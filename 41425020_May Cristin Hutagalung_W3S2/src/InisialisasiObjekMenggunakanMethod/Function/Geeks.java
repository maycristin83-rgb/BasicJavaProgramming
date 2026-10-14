/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InisialisasiObjekMenggunakanMethod.Function;

/**
 *
 * @author MyBook Hype AMD
 */

//Nim   :   41425020
//Nama  :   May Cristin Hutagalung //
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak /

public class Geeks {

    static String name;
    static float price;

    static void set(String n, float p) {
        name = n;
        price = p;
    }

    static void get() {
        System.out.println("Software name is: " + name);
        System.out.println("Software price is: " + price);
    }

    public static void main(String args[]) {
        Geeks.set("Visual studio", 0.0f);
        Geeks.get();
    }
}