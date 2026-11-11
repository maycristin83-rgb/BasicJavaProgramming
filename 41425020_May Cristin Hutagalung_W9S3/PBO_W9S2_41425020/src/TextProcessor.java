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

public class TextProcessor {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String processedFile = "processed.txt";
        String reportFile = "report.txt";

        // Membuat file sumber contoh
        createSampleFile(sourceFile);

        // Memproses file dan menghitung statistik
        processTextFile(sourceFile, processedFile, reportFile);

        // Menampilkan laporan hasil pemrosesan
        displayReport(reportFile);
    }

    // Method untuk membuat file sumber berisi beberapa kalimat
    public static void createSampleFile(String filename) {

        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(filename))) {

            for (String line : sampleText) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Sample file created: " + filename);

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    // Method untuk membaca, memproses, dan menghitung statistik file
    public static void processTextFile(
            String inputFile, String outputFile, String reportFile) {

        try (BufferedReader reader =
                new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer =
                new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter =
                new BufferedWriter(new FileWriter(reportFile))) {

            String line;

            int totalLines = 0;
            int totalWords = 0;
            int totalChars = 0;
            int totalSentences = 0;

            // Menyimpan frekuensi setiap karakter
            Map<Character, Integer> charFrequency = new HashMap<>();

            // Menyimpan frekuensi setiap kata
            Map<String, Integer> wordFrequency = new HashMap<>();

            // Membaca file baris demi baris
            while ((line = reader.readLine()) != null) {

                totalLines++;

                // Mengubah teks menjadi huruf kapital
                String processedLine = line.toUpperCase();
                writer.write(processedLine);
                writer.newLine();

                // Menghitung jumlah kata
                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    totalWords += words.length;

                    // Menghitung frekuensi setiap kata
                    for (String word : words) {
                        String cleanWord = word.toLowerCase()
                                .replaceAll("[^a-z]", "");

                        if (!cleanWord.isEmpty()) {
                            wordFrequency.put(
                                cleanWord,
                                wordFrequency.getOrDefault(cleanWord, 0) + 1
                            );
                        }
                    }
                }

                // Menghitung jumlah karakter
                totalChars += line.length();

                // Menghitung jumlah kalimat berdasarkan tanda titik
                totalSentences += line.length()
                        - line.replace(".", "").length();

                // Menghitung frekuensi karakter
                for (char c : line.toLowerCase().toCharArray()) {

                    if (Character.isLetter(c)) {
                        charFrequency.put(
                            c,
                            charFrequency.getOrDefault(c, 0) + 1
                        );
                    }
                }
            }

            // Membuat laporan statistik
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();

            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();

            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();

            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();

            reportWriter.write("Total Sentences: " + totalSentences);
            reportWriter.newLine();

            // Menghitung rata-rata kata per baris
            double average = totalLines > 0
                    ? (double) totalWords / totalLines : 0;

            reportWriter.write("Average Words per Line: " + average);
            reportWriter.newLine();

            // Mengurutkan karakter berdasarkan frekuensi
            reportWriter.write("\nCHARACTER FREQUENCY:");
            reportWriter.newLine();

            List<Map.Entry<Character, Integer>> sortedChars =
                    new ArrayList<>(charFrequency.entrySet());

            sortedChars.sort(
                    (a, b) -> b.getValue().compareTo(a.getValue())
            );

            for (Map.Entry<Character, Integer> entry : sortedChars) {
                reportWriter.write(
                        entry.getKey() + ": " + entry.getValue()
                );
                reportWriter.newLine();
            }

            // Menampilkan kata yang paling sering muncul
            reportWriter.write("\nMOST FREQUENT WORD:");
            reportWriter.newLine();

            String mostFrequentWord = "-";
            int highestFrequency = 0;

            for (Map.Entry<String, Integer> entry :
                    wordFrequency.entrySet()) {

                if (entry.getValue() > highestFrequency) {
                    highestFrequency = entry.getValue();
                    mostFrequentWord = entry.getKey();
                }
            }

            reportWriter.write(
                    mostFrequentWord + ": " + highestFrequency
            );
            reportWriter.newLine();

            System.out.println("File processing completed!");
            System.out.println("Input: " + inputFile);
            System.out.println("Output: " + outputFile);
            System.out.println("Report: " + reportFile);

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    // Method untuk membaca dan menampilkan laporan
    public static void displayReport(String reportFile) {

        System.out.println("\n=== PROCESSING REPORT ===");

        try (BufferedReader reader =
                new BufferedReader(new FileReader(reportFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
}

/*
Pertanyaan: 
1. Bagaimana cara kerja HashMap untuk menghitung frekuensi karakter? 
Jawab :
- HashMap menyimpan data dalam bentuk pasangan key-value (kunci dan nilai).
- Key merepresentasikan karakter itu sendiri (Character), sedangkan value 
  merepresentasikan jumlah kemunculannya (Integer).
-Saat karakter dibaca satu per satu, program menggunakan charFrequency.
getOrDefault(c, 0) + 1. Jika karakter belum ada di dalam map, nilai default 
yang diambil adalah 0 lalu ditambah 1. Jika karakter sudah ada, nilai frekuensi 
sebelumnya akan diambil lalu ditambah 1, kemudian diperbarui kembali ke dalam HashMap.
2. Mengapa kita menggunakan \\s+ untuk split words daripada spasi biasa? 
Simbol \\s+ adalah regular expression (regex) yang merepresentasikan satu atau 
lebih karakter spasi/whitespace (termasuk spasi tunggal, spasi ganda, tab, atau karakter baris baru).
3. Apa keuntungan menggunakan BufferedReader/BufferedWriter? 
- Efisiensi I/O (Buffer): Keduanya menggunakan memori sementara (buffer) untuk 
membaca atau menulis data secara sekaligus (dalam blok), sehingga mengurangi frekuensi 
akses langsung ke media penyimpanan fisik (disk) yang jauh lebih lambat.
- Kemudahan Membaca Baris: BufferedReader menyediakan method readLine() yang 
sangat memudahkan pembacaan file teks baris demi baris.
*/