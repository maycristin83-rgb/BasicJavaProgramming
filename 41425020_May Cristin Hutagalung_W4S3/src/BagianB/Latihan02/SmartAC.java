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

public class SmartAC implements Switchable, Connectable {
    private int temperature;  // suhu dalam derajat Celsius (private)
    private boolean isOn;     // status sakelar (State), awalnya mati

    public SmartAC(int temperature) {
        // Suhu dibatasi rentang wajar 16 - 30
        this.temperature = Math.max(16, Math.min(30, temperature));
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("[AC Pintar] Dinyalakan pada suhu " + temperature + " C");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("[AC Pintar] Dimatikan.");
    }

    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // State management: tolak koneksi jika perangkat masih mati
        if (!isOn) {
            System.out.println("[Error] AC Pintar tidak dapat terhubung ke WiFi: "
                    + "perangkat masih mati. Panggil turnOn() terlebih dahulu.");
            return;
        }
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid
                + " (IP: " + ipAddress + ")");
    }
}
