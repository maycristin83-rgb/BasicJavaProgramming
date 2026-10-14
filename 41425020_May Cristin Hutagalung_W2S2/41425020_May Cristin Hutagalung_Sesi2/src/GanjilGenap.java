/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;

public class GanjilGenap {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.print("Masukkan bilangan: ");
        int bilangan = input.nextInt();
 
        // Bilangan genap jika sisa bagi dengan 2 sama dengan 0
        if (bilangan % 2 == 0) {
            System.out.println(bilangan + " adalah bilangan Genap");
        } else {
            System.out.println(bilangan + " adalah bilangan Ganjil");
        }
 
        input.close();
    }
    
}