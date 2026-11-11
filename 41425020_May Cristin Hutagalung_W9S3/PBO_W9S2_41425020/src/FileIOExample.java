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

import java.util.*;
import java.io.*;

public class FileIOExample {
    public static void main(String[] args) {
        String inputFile = "data.txt";
        String outputFile = "output.txt";
        
        // Tulis data ke file
        writeToFile(inputFile);
        
        // Baca data dari file
        readFromFile(inputFile);
        
        // Process dan tulis ke file baru
        processFile(inputFile, outputFile);
    }
    
    public static void writeToFile(String filename) {
        // Menggunakan try-with-resources untuk otomatis menutup BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Alice, 25, Computer Science");
            writer.newLine();
            writer.write("Bob, 30, Mathematics");
            writer.newLine();
            writer.write("Charlie, 22, Physics");
            writer.newLine();
            writer.write("Diana, 28, Chemistry");
            writer.newLine();
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("File berhasil dibaca");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void processFile(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            writer.write("NAME, AGE, MAJOR, STATUS");
            writer.newLine();
            
            while ((line = reader.readLine()) != null) {
                // Split data berdasarkan koma
                String[] data = line.split(",");
                String name = data[0].trim().toUpperCase();
                int age = Integer.parseInt(data[1].trim());
                String major = data[2].trim();
                String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";
                
                // Tulis data yang telah diproses
                String processedLine = String.format("%s, %d, %s, %s", name, age, major, status);
                writer.write(processedLine);
                writer.newLine();
                System.out.println("Processed: " + processedLine);
            }
            System.out.println("File berhasil diproses dan disimpan sebagai " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}

/*
Pertanyaan: 
1. Apa keuntungan menggunakan try-with-resources?
Jawab : Secara otomatis menutup *resource* (seperti stream file, reader, atau 
writer) begitu blok `try` selesai dieksekusi atau terjadi error, sehingga kita 
tidak perlu menulis perintah `.close()` secara manual di dalam blok `finally`
2. Mengapa perlu menangani FileNotFoundException dan IOException secara terpisah?
Jawab : `FileNotFoundException` adalah turunan (*subclass*) dari `IOException` 
yang spesifik mendeteksi jika file yang ingin dibaca tidak ditemukan. 
Memisahkannya memungkinkan program memberikan pesan error yang lebih spesifik 
kepada pengguna dibandingkan error I/O umum lainnya[cite: 5].
3. **Apa yang terjadi jika file `data.txt` sudah ada sebelum program dijalankan?**
Jawab :Jika menggunakan `FileWriter(filename)` standar, isi file yang lama akan 
**ditimpa total (*overwrite*)** dari awal. Jika ingin menambahkan data tanpa 
menghapus data lama, kita harus mengaktifkan mode *append* (`new FileWriter(filename, true)`)
*/