/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/


public class VehicleRental {
    private String plateNumber;
    private double rentalRatePerDay;
    private int rentalDays;

    public VehicleRental(String plateNumber, double rate) {
        // Validasi lewat setter agar aturan hanya ditulis sekali
        setPlateNumber(plateNumber);
        setRentalRatePerDay(rate);
    }

    public String getPlateNumber() { return plateNumber; }
    public double getRentalRatePerDay() { return rentalRatePerDay; }
    public int getRentalDays() { return rentalDays; }

    // Plat nomor tidak boleh kosong
    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Plat nomor tidak boleh kosong!");
        }
        this.plateNumber = plateNumber;
    }

    // Tarif harus positif
    public void setRentalRatePerDay(double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Tarif per hari harus lebih dari 0!");
        }
        this.rentalRatePerDay = rate;
    }

    // Lama sewa minimal 1 hari
    public void setRentalDays(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Lama sewa minimal 1 hari!");
        }
        this.rentalDays = days;
    }

    // Total biaya: subtotal dikurangi potongan dari objek diskon (runtime)
    public double getTotalCost(Discountable discount) {
        double subtotal = rentalRatePerDay * rentalDays;
        double potongan = (discount == null) ? 0 : discount.calculateDiscount(subtotal);
        // Potongan dijaga 0..subtotal agar total tidak pernah negatif
        potongan = Math.max(0, Math.min(potongan, subtotal));
        return subtotal - potongan;
    }
}
