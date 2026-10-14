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

public class SmartHomeMain {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp(80);
        SmartAC ac = new SmartAC(22);

        // Uji aturan state: konek WiFi saat perangkat masih mati -> error
        lampu.connectToWifi("Rumah_Indah_5G", "192.168.1.49");

        // Alur normal lampu: nyala -> konek WiFi
        lampu.turnOn();
        lampu.connectToWifi("Rumah_Indah_5G", "192.168.1.50");

        // Alur normal AC: nyala -> konek WiFi -> mati
        ac.turnOn();
        ac.connectToWifi("Rumah_Indah_5G", "192.168.1.51");
        ac.turnOff();

        lampu.turnOff();
    }
}
