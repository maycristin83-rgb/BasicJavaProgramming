/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

interface Kendaraan {
    public void bergerak(); 
}


class Mobil implements Kendaraan {
    @Override 
    public void bergerak() {
        System.out.println("Mobil Berjalan");
    }
}
class Motor implements Kendaraan {
    @Override 
    public void bergerak() {
        System.out.println("Motor Standing");
    }
}

public class Utama {
    public static void main(String[] args) {
        Kendaraan mobilBaru = new Mobil();
        Kendaraan motorBaru = new Motor();
        
        mobilBaru.bergerak(); // Output: Mobil Berjalan
        motorBaru.bergerak(); // Output: Motor Standing
    }
}