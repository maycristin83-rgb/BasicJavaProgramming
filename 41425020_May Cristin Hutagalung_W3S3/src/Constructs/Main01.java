/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constructs;

/**
 *
 * @author MyBook Hype AMD
 */

class Geeks {

    // data members of the class
    String name;
    int id;

    Geeks(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
// Nama  : May Cristin Hutagalung
// Nim   : 41425020
// Prodi : DIV-Teknologi Rekayasa Perangkat Lunak

public class Main01
{
    public static void main(String[] args)
    {
        // This would invoke the parameterized constructor
        Geeks geek1 = new Geeks("Sweta", 68);
        System.out.println("GeekName: " + geek1.name
                + " and GeekId: " + geek1.id);
    }
}