/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*  Nim : 41425020
    Nama: May Cristin Hutagalung
*/
/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Scanner;

public class ShoppingCart {
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array dengan kapasitas maksimal 100 item
        final int MAX_ITEM = 100;
        String[] items = new String[MAX_ITEM];
        int count = 0; // jumlah item yang sedang tersimpan

        boolean running = true;

        while (running) {
            System.out.println("=== Daftar Belanja ===");
            System.out.println("1. Tambah item");
            System.out.println("2. Hapus item");
            System.out.println("3. Tampilkan semua item");
            System.out.println("4. Cari item");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = Integer.parseInt(scanner.nextLine().trim());

            switch (pilihan) {
                case 1: // Dapat Menambakan item
                    if (count >= MAX_ITEM) {
                        System.out.println("Daftar belanja penuh!");
                        break;
                    }
                    System.out.print("Masukkan item: ");
                    String newItem = scanner.nextLine();
                    items[count] = newItem;
                    count++; // tambah jumlah item
                    System.out.println(newItem + " berhasil ditambahkan!");
                    break;

                case 2: // Dapat Menghapus item berdasarkan posisi (1-based)
                    if (count == 0) {
                        System.out.println("Daftar belanja masih kosong.");
                        break;
                    }
                    System.out.print("Hapus item pada posisi: ");
                    int pos = Integer.parseInt(scanner.nextLine().trim());

                    if (pos < 1 || pos > count) {
                        System.out.println("Posisi tidak valid!");
                        break;
                    }

                    String removedItem = items[pos - 1];
                    // Memindahkan dan menggeser semua item setelah posisi 
                    // yang dihapus ke kiri satu langkah
                    for (int i = pos - 1; i < count - 1; i++) {
                        items[i] = items[i + 1];
                    }
                    items[count - 1] = null; // kosongkan slot terakhir
                    count--; // Dapat Menguranngi jumlah item
                    System.out.println(removedItem + " berhasil dihapus!");
                    break;

                case 3: // Akan menampilkan semua item
                    System.out.println("Daftar belanja:");
                    if (count == 0) {
                        System.out.println("(kosong)");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + items[i]);
                        }
                    }
                    break;

                case 4: // Mencari item berdasarkan nama
                    System.out.print("Cari item: ");
                    String query = scanner.nextLine();
                    int foundIndex = -1;
                    for (int i = 0; i < count; i++) {
                        if (items[i].equalsIgnoreCase(query)) {
                            foundIndex = i;
                            break;
                        }
                    }
                    if (foundIndex != -1) {
                        System.out.println(query + " ditemukan pada posisi " + (foundIndex + 1));
                    } else {
                        System.out.println(query + " tidak ditemukan dalam daftar.");
                    }
                    break;

                case 5: // Keluar dari program
                    System.out.println("Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}
