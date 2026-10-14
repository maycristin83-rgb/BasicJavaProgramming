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

public class Student03 {
    

    int roll;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student03) {
            return this.roll == ((Student03) o).roll;
        }
        return false;
    }

    public static void main(String[] args) {
        Student03 s1 = new Student03();
        s1.roll = 101;

        Student03 s2 = new Student03();
        s2.roll = 101;

        Student03 s3 = new Student03();
        s3.roll = 102;

        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}
  
