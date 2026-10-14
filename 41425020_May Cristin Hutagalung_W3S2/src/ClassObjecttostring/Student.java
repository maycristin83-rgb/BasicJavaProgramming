/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObjecttostring;

/**
 *
 * @author MyBook Hype AMD
 */

//Nim   :   41425020
//Nama  :   May Cristin Hutagalung //
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak /


public class Student {

    @Override
    public String toString() {
        return "Student object";
    }

    public static void main(String[] args) {
        Student s = new Student();        // membuat objek Student
        System.out.println(s.toString()); // memanggil toString()
    }
}