/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BagianA.Praktik02;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

interface PaymentMethod {
    // Konstanta (otomatis public static final)
    double TRANSACTION_FEE = 2500.0;

    void pay(double amount);            // proses pembayaran
    String getPaymentDetails();         // detail metode pembayaran
}

// Implementasi 1: dompet digital (dikenai biaya admin)
class EWalletPayment implements PaymentMethod {
    private String phoneNumber;

    public EWalletPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        double total = amount + TRANSACTION_FEE;   // jumlah + biaya admin
        System.out.println("[E-Wallet " + phoneNumber + "] Pembayaran diproses: Rp" + amount
                + " (Biaya admin: Rp" + TRANSACTION_FEE + ") | Total: Rp" + total);
    }

    @Override
    public String getPaymentDetails() {
        return "Metode: E-Wallet (" + phoneNumber + ")";
    }
}

// Implementasi 2: kartu kredit (logika berbeda, tanpa biaya admin)
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[Credit Card " + cardNumber
                + "] Pembayaran berhasil diverifikasi sebesar: Rp" + amount);
    }

    @Override
    public String getPaymentDetails() {
        return "Metode: Kartu Kredit (" + cardNumber + ")";
    }
}

// Kelas utama: memakai referensi bertipe interface (polimorfisme)
public class PaymentSystem {
    public static void main(String[] args) {
        PaymentMethod payment1 = new EWalletPayment("08123456789");
        PaymentMethod payment2 = new CreditCardPayment("4111-XXXX-XXXX-1234");

        // Perintah sama (pay), perilaku berbeda sesuai objek aslinya
        payment1.pay(50000);
        payment2.pay(150000);
    }
}

