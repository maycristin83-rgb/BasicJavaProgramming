/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Array_Dalam_java {

    public static void main(String[] args) {
        // buat array 10 elemen
        int anArray[] = new int[10];

        // isi nilai
        anArray[0] = 100;
        anArray[1] = 200;

        // Setiap baris bisa memiliki panjang berbeda (array 2 dimensi / jagged array)
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        System.out.println(names[0][0] + names[1][0]); // Mr. Smith
        System.out.println(names[0][2] + names[1][1]); // Ms. Jones
    }
}