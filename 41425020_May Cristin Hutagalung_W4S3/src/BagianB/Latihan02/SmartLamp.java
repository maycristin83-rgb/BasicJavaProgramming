/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BagianB.Latihan02;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

public class SmartLamp implements Switchable, Connectable {
    private int brightness;   // persentase kecerahan (private)
    private boolean isOn;     // status sakelar (State), awalnya mati

    public SmartLamp(int brightness) {
        // Kecerahan dibatasi 0 - 100
        this.brightness = Math.max(0, Math.min(100, brightness));
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("[Lampu Pintar] Dinyalakan dengan kecerahan " + brightness + "%");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("[Lampu Pintar] Dimatikan.");
    }

    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // State management: tolak koneksi jika perangkat masih mati
        if (!isOn) {
            System.out.println("[Error] Lampu Pintar tidak dapat terhubung ke WiFi: "
                    + "perangkat masih mati. Panggil turnOn() terlebih dahulu.");
            return;
        }
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid
                + " (IP: " + ipAddress + ")");
    }
}

