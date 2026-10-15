/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

abstract class Animal {
    abstract void suara();

    void modom() {
        System.out.println("Hewan modom");
    }

    void bernafas() {
        System.out.println("Hewan HIAAHH");
    }
}

class kucing extends Animal {
    void suara() {
        System.out.println("Rawr");
    }

    void bernafas() {
        System.out.println("HAIAHHH");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new kucing();

        a.modom();
        a.suara();
        a.bernafas();
    }
}