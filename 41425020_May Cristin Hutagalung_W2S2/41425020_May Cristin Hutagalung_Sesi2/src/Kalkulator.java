/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;
        
public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka pertama: ");
        int a = input.nextInt();
        System.out.print("Masukkan angka kedua: ");
        int b = input.nextInt();

        System.out.println("Tambah: " + (a + b));
        System.out.println("Kurang: " + (a - b));
        System.out.println("Kali: " + (a *b));
        System.out.println("Bagi: " + ((double) a / b));
    }
}

// Pertanyaan Pemantik : //

// Praktek 1: Apa perbedaan nilai asli double dengan hasil casting int?
// Jawab : Perbedaan utama antara nilai asli double dan hasil casting ke 
//         int terletak pada pemotongan komponen desimal dan kapasitas memori 
//         penyimpanan.
// Praktek 2: Mengapa pembagian int perlu di-casting ke double?
// Jawab : casting salah satu atau kedua variabel int menjadi 
//         double sebelum pembagian dilakukan bertujuan untuk 
//         mencegah pemotongan angka desimal (truncation) agar 
//         hasil pembagiannya akurat dan memiliki nilai di belakang koma
// Apa risiko jika pembagi = 0?
// Jawab : Terjadinya runtime error atau exception yang disebut 
//         ArithmeticException (Division by Zero).