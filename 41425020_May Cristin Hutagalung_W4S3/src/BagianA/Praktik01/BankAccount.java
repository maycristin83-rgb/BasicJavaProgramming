/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BagianA.Praktik01;

/**
 *
 * @author MyBook Hype AMD
 */

/*Nim	: 41425020
  Nama	: May Cristin Hutagalung
  Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

public class BankAccount {
    // Atribut dikunci private: tidak bisa diubah langsung dari luar kelas
    private String accountNumber;
    private double balance;

    // Constructor: saldo awal negatif ditolak dan diatur ke 0
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Saldo awal tidak boleh negatif! Diatur ke 0.");
            this.balance = 0;
        }
    }

    // Getter: hanya membaca nilai
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setor: jumlah harus positif
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Setor berhasil: Rp" + amount);
        } else {
            System.out.println("Jumlah setoran harus lebih besar dari 0!");
        }
    }

    // Tarik tunai: jumlah harus valid dan tidak boleh melebihi saldo
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Jumlah penarikan tidak valid!");
        } else if (amount > this.balance) {
            System.out.println("Penarikan gagal: Saldo tidak mencukupi!");
        } else {
            this.balance -= amount;
            System.out.println("Tarik tunai berhasil: Rp" + amount);
        }
    }

    // Program utama untuk menguji validasi
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 500000);

        acc.deposit(-100000);   // ditolak: setoran negatif
        acc.withdraw(700000);   // ditolak: melebihi saldo
        acc.withdraw(200000);   // berhasil

        System.out.println("Saldo akhir akun " + acc.getAccountNumber()
                + ": Rp" + acc.getBalance());
    }
}
