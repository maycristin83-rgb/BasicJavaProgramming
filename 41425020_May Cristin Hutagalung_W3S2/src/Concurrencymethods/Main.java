/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concurrencymethods;

/**
 *
 * @author MyBook Hype AMD
 */
//Nim   :   41425020
//Nama  :   May Cristin Hutagalung
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak


class SharedResource {
    synchronized void tunggu() {
        try {
            System.out.println("Thread menunggu...");
            wait(); // thread berhenti sampai dibangunkan
            System.out.println("Thread dibangunkan!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void bangunkan() {
        System.out.println("Membangunkan thread...");
        notify(); // membangunkan satu thread yang sedang wait()
    }
}
public class Main {
     public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.tunggu());
        t1.start();

        Thread.sleep(1000); // beri jeda 1 detik

        Thread t2 = new Thread(() -> resource.bangunkan());
        t2.start();
    } 
}
