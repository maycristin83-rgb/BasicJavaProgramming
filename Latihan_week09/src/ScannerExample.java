/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        
        System.out.print("Masukkan umur: ");
        int umur = sc.nextInt();
        
        System.out.println("Halo " + nama + ", umurmu " + umur + " tahun.");
    }
}