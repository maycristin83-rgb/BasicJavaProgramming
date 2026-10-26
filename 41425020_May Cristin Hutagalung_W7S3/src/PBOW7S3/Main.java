/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBOW7S3;

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/


public class Main {

    public static void main(String[] args) {

        // Membuat objek laptop
        Laptop laptop = new Laptop("ASUS", 85);

        try {
            // Menampilkan informasi laptop
            laptop.tampilkanInfo();

            // Memeriksa kondisi suhu laptop
            laptop.periksaSuhu();

        } catch (LaptopException e) {
            // Menangani exception jika laptop terlalu panas
            System.out.println("PERINGATAN: " + e.getMessage());

        } finally {
            // Selalu dijalankan setelah try-catch
            System.out.println("Pemeriksaan laptop selesai.");
        }
    }
}
