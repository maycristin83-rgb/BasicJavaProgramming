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

public class Student02 {
    
    int roll;
    
    @Override
    public int hashCode() {
        return roll;
        
    }
    public static void main(String[] args) {
        Student02 s1 = new Student02();
        s1.roll = 101;
        
        Student02 s2 = new Student02();
        s2.roll = 102;
        
        System.out.println("HashCode s1: " + s1.hashCode());
        System.out.println("HashCode s2: " + s2.hashCode());
        
    }
    
}
