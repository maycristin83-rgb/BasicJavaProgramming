/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObjectdiJava;

/**
 *
 * @author MyBook Hype AMD
 */
// Nama  : May Cristin Hutagalung
// Nim   : 41425020
// Prodi : DIV-Teknologi Rekayasa Perangkat Lunak

public class Geeks02 {
    public static void main(String[] args)
    {
        Object o = new String("GeeksForGeeks");
        Class c = o.getClass();
        System.out.println("Class of Object o is: "
                + c.getName());
    }
}