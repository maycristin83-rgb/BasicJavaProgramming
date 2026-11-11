/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

/*
Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak
*/

import java.io.*;
import java.util.*;

public class FileIOExampleMod {
    public static void main(String[] args) {
        String inputFile = "data.txt";
        String outputFile = "output.txt";
        
        // 1. Menulis data baru ke file dengan mode append agar data lama tidak terhapus
        writeToFileAppend(inputFile, "Eko, 27, Informatics");
        
        // 2. Membaca file dan menghitung rata-rata usia dari seluruh baris data
        hitungRataRataUsia(inputFile);
        
        // 3. Memproses file dengan penanganan NumberFormatException yang aman
        processFileSafe(inputFile, outputFile);
    }
    
    // Method untuk menulis data dengan mode Append
    public static void writeToFileAppend(String filename, String dataLine) {
        // Parameter 'true' pada FileWriter mengaktifkan mode append (menambahkan data di akhir file)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(dataLine);
            writer.newLine();
            System.out.println("Data baru berhasil ditambahkan secara append ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    // Method untuk membaca file dan menghitung rata-rata usia
    public static void hitungRataRataUsia(String filename) {
        System.out.println("\n=== HITUNG RATA-RATA USIA ===");
        int totalAge = 0;
        int count = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    try {
                        // Mengonversi string usia (indeks ke-1) menjadi integer
                        int age = Integer.parseInt(parts[1].trim());
                        totalAge += age; // Akumulasi total usia
                        count++;         // Menghitung jumlah data valid
                    } catch (NumberFormatException e) {
                        // Menangkap error jika teks pada kolom usia bukan angka valid
                        System.out.println("Peringatan: Gagal parsing usia pada baris: " + line);
                    }
                }
            }
            // Menghitung dan mencetak rata-rata jika data valid ditemukan
            if (count > 0) {
                double avg = (double) totalAge / count;
                System.out.println("Rata-rata usia: " + avg);
            } else {
                System.out.println("Tidak ada data usia yang valid.");
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }
    
    // Method proses file dengan penanganan NumberFormatException yang aman
    public static void processFileSafe(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE DENGAN SAFE PARSING ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            writer.write("NAME, AGE, MAJOR, STATUS");
            writer.newLine();
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) continue; // Lewati jika format kolom kurang dari 3
                
                String name = data[0].trim().toUpperCase();
                int age = 0;
                
                // Exception handling khusus untuk mengantisipasi error format angka pada usia
                try {
                    age = Integer.parseInt(data[1].trim());
                } catch (NumberFormatException e) {
                    // Jika gagal parsing, usia di-set default menjadi 0 agar program tidak crash
                    System.out.println("Format usia salah pada data: " + data[0] + ". Usia di-set 0.");
                }
                
                String major = data[2].trim();
                // Operator ternary untuk menentukan status berdasarkan usia
                String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";
                
                // Memformat hasil dan menulisnya ke file output
                String processedLine = String.format("%s, %d, %s, %s", name, age, major, status);
                writer.write(processedLine);
                writer.newLine();
                System.out.println("Processed: " + processedLine);
            }
            System.out.println("File berhasil diproses ke " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
