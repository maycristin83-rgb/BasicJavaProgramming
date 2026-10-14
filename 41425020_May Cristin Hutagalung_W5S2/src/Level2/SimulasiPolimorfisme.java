/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Level2;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

// Tantangan Ekstra: Polimorfisme dengan array bertipe parent class
public class SimulasiPolimorfisme {
    public static void main(String[] args) {
        System.out.println("=== TANTANGAN EKSTRA: POLIMORFISME ===");

        // Array bertipe PARENT (KendaraanEkspedisi),
        // diisi objek CHILD yang berbeda (TrukBox dan MobilVan)
        KendaraanEkspedisi[] armada = {
            new TrukBox("B 9081 TXT", 5000),
            new MobilVan("B 1122 KAA", 800),
            new TrukBox("BK 7777 DEL", 3000)
        };

        // Satu for-loop untuk seluruh objek di array
        for (KendaraanEkspedisi k : armada) {
            k.infoKendaraan();                    // method biasa (diwarisi dari parent)
            k.angkutBarang("Paket Elektronik");   // dipanggil lewat referensi parent;
                                                  // JVM menjalankan versi milik objek aslinya
            System.out.println("---------------------------------");
        }
    }
}