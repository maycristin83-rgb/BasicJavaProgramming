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

public class TextProcessorMod {
    public static void main(String[] args) {
        String sourceFile = "source_mod.txt";
        String processedFile = "processed_mod.txt";
        String reportFile = "report_mod.txt";

        createSampleFile(sourceFile);
        processTextFile(sourceFile, processedFile, reportFile);
        displayReport(reportFile);
    }

    public static void createSampleFile(String filename) {
        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : sampleText) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sample file created: " + filename);
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void processTextFile(String inputFile, String outputFile, String reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))) {

            String line;
            int totalLines = 0;
            int totalWords = 0;
            int totalChars = 0;
            int totalSentences = 0;   // MODIFIKASI 1: penghitung kalimat
            Map<Character, Integer> charFrequency = new HashMap<>();
            Map<String, Integer> wordFrequency = new HashMap<>();   // MODIFIKASI 2: kata -> jumlah muncul

            while ((line = reader.readLine()) != null) {
                totalLines++;

                writer.write(line.toUpperCase());
                writer.newLine();

                String[] words = line.split("\\s+");
                totalWords += words.length;
                totalChars += line.length();

                // ===== MODIFIKASI 1: hitung kalimat =====
                // setiap tanda titik '.' dianggap sebagai akhir 1 kalimat
                for (char c : line.toCharArray()) {
                    if (c == '.') {
                        totalSentences++;
                    }
                }

                // ===== MODIFIKASI 2: hitung frekuensi kata =====
                for (String word : words) {
                    // huruf kecil semua + buang tanda baca supaya "Programming." sama dengan "programming"
                    String clean = word.toLowerCase().replaceAll("[^a-z]", "");
                    if (!clean.isEmpty()) {
                        wordFrequency.put(clean, wordFrequency.getOrDefault(clean, 0) + 1);
                    }
                }

                for (char c : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }

            // Write report
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();
            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();
            reportWriter.write("Total Sentences: " + totalSentences);   // hasil modifikasi 1
            reportWriter.newLine();
            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();
            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();
            reportWriter.write("Average Words per Line: " + (double) totalWords / totalLines);
            reportWriter.newLine();
            reportWriter.newLine();

            // ===== MODIFIKASI 2: tulis kata paling sering muncul =====
            // cari nilai frekuensi tertinggi dulu
            int maxCount = 0;
            for (int count : wordFrequency.values()) {
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            // kumpulkan semua kata yang frekuensinya sama dengan maksimum (bisa lebih dari satu)
            List<String> topWords = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                if (entry.getValue() == maxCount) {
                    topWords.add(entry.getKey());
                }
            }
            Collections.sort(topWords);   // urutkan abjad supaya hasil selalu sama
            reportWriter.write("MOST FREQUENT WORD(S): " + topWords + " (muncul " + maxCount + " kali)");
            reportWriter.newLine();
            reportWriter.newLine();

            reportWriter.write("CHARACTER FREQUENCY:");
            reportWriter.newLine();

            List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequency.entrySet());
            sortedChars.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (Map.Entry<Character, Integer> entry : sortedChars) {
                reportWriter.write(entry.getKey() + ": " + entry.getValue());
                reportWriter.newLine();
            }

            System.out.println("File processing completed!");
            System.out.println("  - Input: " + inputFile);
            System.out.println("  - Output: " + outputFile);
            System.out.println("  - Report: " + reportFile);

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    public static void displayReport(String reportFile) {
        System.out.println("\n=== PROCESSING REPORT ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
}
