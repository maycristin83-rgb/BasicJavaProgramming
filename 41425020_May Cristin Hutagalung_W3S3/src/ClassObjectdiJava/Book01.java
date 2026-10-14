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
public class Book01 implements Cloneable {
    private String t;
    public Book01(String t) {
        this.t = t;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getTitle() {
        return t;
    }

    public static void main(String[] args) {
        try {
            Book01 b1 = new Book01("Java Basics");
            Book01 b2 = (Book01) b1.clone();

            System.out.println("Judul buku b1: " + b1.getTitle());
            System.out.println("Judul buku b2: " + b2.getTitle());
            System.out.println("Apakah b1 dan b2 objek yang sama? " + (b1 == b2));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}