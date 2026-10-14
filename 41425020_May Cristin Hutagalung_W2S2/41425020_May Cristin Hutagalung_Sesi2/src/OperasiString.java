/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;


public class OperasiString {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         System.out.print("Masukkan nama lengkap: ");
         String nama = input.nextLine();

        System.out.println("Panjang string: " + nama.length());
        System.out.println("Huruf pertama: " + nama.charAt(0));
        System.out.println("Mengandung spasi? " + nama.contains(" "));
    }    
}

// Pertanyaan Pemantik:
// Bagaimana jika nama yang diinput dengan lebih dari satu spasi?
// Jawab : Jika nama diinput lebih dari satu kata, program akan error 
// jika memakai input.next() karena hanya membaca kata pertama saja. 
// Sisa katanya akan tertinggal di memori dan dianggap sebagai input untuk 
// pertanyaan berikutnya, sehingga program crash. 