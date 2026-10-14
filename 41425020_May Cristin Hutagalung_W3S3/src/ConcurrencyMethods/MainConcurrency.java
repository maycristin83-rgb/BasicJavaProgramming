/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConcurrencyMethods;

/**
 *
 * @author MyBook Hype AMD
 */

// Nama  : May Cristin Hutagalung
// Nim   : 41425020
// Prodi : DIV-Teknologi Rekayasa Perangkat Lunak

public class MainConcurrency {
    public static void main(String[] args) {
        AntreanShared antrean = new AntreanShared();

        // Thread Produsen
        Thread produsen = new Thread(() -> {
            String[] listPesan = {"Halo", "Belajar Java", "Selesai"};
            for (String p : listPesan) {
                antrean.kirimPesan(p);
            }
        });

        // Thread Konsumen
        Thread konsumen = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                antrean.ambilPesan();
            }
        });

        produsen.start();
        konsumen.start();
    }
}