/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HybridInheritance;

/**
 *
 * @author MyBook Hype AMD
 */
//Nim   :   41425020
//Nama  :   May Cristin Hutagalung //
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak /

class Vehicle {
    Vehicle() {
        System.out.println("This is a Vehicle");
    }
}

// Hierarchical: Car dan Fare sama-sama extends Vehicle
class Car extends Vehicle {
    Car() {
        System.out.println("This Vehicle is Car");
    }
}

class Fare extends Vehicle {
    Fare() {
        System.out.println("This Vehicle is Fare");
    }
}

// Multilevel: Bus extends Fare (bukan langsung dari Vehicle)
class Bus extends Fare {
    Bus() {
        System.out.println("This Fare Vehicle is Bus");
    }
}

public class Test {
    public static void main(String[] args) {
        Car obj1 = new Car();
        System.out.println("---");
        Bus obj2 = new Bus();
    }
}