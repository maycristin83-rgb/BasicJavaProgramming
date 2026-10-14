/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleinheritance;

/**
 *
 * @author MyBook Hype AMD
 */

//Nim   :   41425020
//Nama  :   May Cristin Hutagalung
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak


class Vehicle { // Super class
    Vehicle() {
        System.out.println("This is a Vehicle");
    }
}

// Subclass
class Car extends Vehicle {
    Car() {
        System.out.println("This Vehicle is Car");
    }
}

public class Test {
    public static void main(String[] args) {
        Car obj = new Car();
    }
}
