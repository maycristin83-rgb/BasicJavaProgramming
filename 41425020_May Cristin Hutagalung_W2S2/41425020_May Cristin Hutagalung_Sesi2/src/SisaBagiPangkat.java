/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.util.Scanner;

public class SisaBagiPangkat {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.print("Masukkan angka pertama: ");
        int a = input.nextInt();
 
        System.out.print("Masukkan angka kedua: ");
        int b = input.nextInt();
 
        // Operatornya menghasilkan sisa pembagian a oleh b
        int sisaBagi = a % b;
 
        // Math.pow(a, b) menghitung a pangkat b, hasilnya bertipe double
        // sehingga perlu di-casting ke int agar tampil sebagai bilangan bulat
        int pangkat = (int) Math.pow(a, b);
 
        System.out.println("Sisa bagi: " + sisaBagi);
        System.out.println("Pangkat: " + pangkat);
 
        input.close();
    }  
}
