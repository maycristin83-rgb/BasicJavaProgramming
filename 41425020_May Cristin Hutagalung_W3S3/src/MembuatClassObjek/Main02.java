/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MembuatClassObjek;

/**
 *
 * @author MyBook Hype AMD
 */
// Nama  : May Cristin Hutagalung
// Nim   : 41425020
// Prodi : DIV-Teknologi Rekayasa Perangkat Lunak

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Class Student khusus untuk latihan Deserialization ini
// WAJIB implements Serializable supaya bisa disimpan/dibaca dari file
class Student implements java.io.Serializable {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

public class Main02 {
    public static void main(String[] args)
    {
        // Serialization
        try (ObjectOutputStream out
                = new ObjectOutputStream(
                    new FileOutputStream("student.ser"))) {
            out.writeObject(new Student("Alice"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("student.ser"))) {
            Student s = (Student)in.readObject();
            System.out.println(s);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}