/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
// Nim     : 41425020 //
// Nama    : May Cristin Hutagalung //
// Prodi   : DIV-Teknologi Rekayasa Perangkat Lunak //


class Student {
    int id;
    String n;

    public Student(int id, String n) {
        this.id = id;
        this.n = n;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(10, "Alice");

        System.out.println(s1.id);
        System.out.println(s1.n);
    }
}