/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.test;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

import id.ac.del.rental.*;

/** Menguji VehicleRental dengan berbagai skema diskon (polimorfisme). */
public class TestRental {
    public static void main(String[] args) {
        VehicleRental v = new VehicleRental("BK 1234 DEL", 250000);
        v.setRentalDays(7);

        // Objek diskon dikirim saat runtime; tipe parameter tetap Discountable
        System.out.println("Tanpa diskon : Rp" + v.getTotalCost(null));
        System.out.println("Member       : Rp" + v.getTotalCost(new MemberDiscount()));
        System.out.println("Flash Sale   : Rp" + v.getTotalCost(new FlashSaleDiscount()));
        System.out.println("Corporate    : Rp" + v.getTotalCost(new CorporateDiscount()));

        // Data tidak valid sekarang ditolak
        try {
            v.setRentalDays(-7);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] " + e.getMessage());
        }
    }
}
