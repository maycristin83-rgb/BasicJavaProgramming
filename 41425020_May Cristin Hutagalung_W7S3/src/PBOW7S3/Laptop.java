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

public class Laptop {

    // Atribut laptop
    private String merek;
    private double suhu;

    // Constructor untuk mengisi data laptop
    public Laptop(String merek, double suhu) {
        this.merek = merek;
        this.suhu = suhu;
    }

    // Memeriksa suhu laptop
    public void periksaSuhu() throws LaptopException {

        // Suhu di atas 80 derajat dianggap terlalu panas
        if (suhu > 80) {
            throw new LaptopException(
                "Laptop terlalu panas! Segera dinginkan laptop."
            );
        }

        System.out.println("Suhu laptop masih normal.");
    }

    // Menampilkan informasi laptop
    public void tampilkanInfo() {
        System.out.println("Merek Laptop : " + merek);
        System.out.println("Suhu Laptop  : " + suhu + " derajat Celsius");
    }
}
