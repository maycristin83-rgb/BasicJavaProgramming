/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;


public class Lingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14;

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        if (r < 0) {
             System.out.println("Error: jari-jari tidak boleh negatif.");
        } else {
             double luas = PI * r * r;
             double keliling = 2 * PI * r;
             System.out.println("Luas: " + luas);
             System.out.println("Keliling: " + keliling);
        }
    }
}

// Pertanyaan Pemantik:

// 1.Mengapa kita perlu validasi r < 0?
//  Jawab : Melakukan validasi r < 0 (di mana r biasanya adalah jari-jari 
//          atau jarak) untuk mencegah kesalahan logika matematika dan error 
//          pada program, karena secara fisik dan geometris, ukuran panjang 
//          atau jarak tidak pernah bernilai negatif.

// 2.Dalam aplikasi nyata, di mana validasi input sangat penting?
// Jawab : Dalam aplikasi nyata, validasi input sangat penting di sisi backend
//         (server) dan pada setiap titik di mana data dari pengguna atau 
//         sistem eksternal masuk ke dalam aplikasi