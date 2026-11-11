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

public class StringManipulation {
    public static void main(String[] args) {
        // Deklarasi string dengan spasi di awal dan akhir
        String text = "Hello World! Welcome to Java Programming";
        
        System.out.println("=== BASIC STRING OPERATIONS ===");
        // .length() digunakan untuk menghitung total seluruh karakter termasuk spasi
        System.out.println("Original: '" + text + "'");
        System.out.println("Length: " + text.length());
        
        // .trim() berfungsi menghapus spasi kosong di awal dan akhir string
        System.out.println("Trimmed: '" + text.trim() + "'");
        
        // .toUpperCase() mengubah seluruh huruf menjadi huruf kapital
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");
        
        // .toLowerCase() mengubah seluruh huruf menjadi huruf kecil
        System.out.println("Lowercase: '" + text.toLowerCase() + "'");
        
        // Substring dan indexing
        System.out.println("\n=== SUBSTRING & INDEXING ===");
        // .charAt(index) mengambil karakter spesifik berdasarkan indeks (dimulai dari 0)
        System.out.println("Character at index 5: '" + text.charAt(5) + "'");
        
        // .substring(beginIndex, endIndex) memotong string dari indeks awal sampai sebelum indeks akhir
        System.out.println("Substring (7-12): '" + text.substring(7, 12) + "'");
        
        // .indexOf("kata") mencari posisi indeks pertama kali kata tersebut ditemukan
        System.out.println("Index of 'World': " + text.indexOf("World"));
        
        // .lastIndexOf("karakter") mencari posisi indeks terakhir kali karakter muncul
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));
        
        // Replacement dan comparison
        System.out.println("\n=== REPLACEMENT & COMPARISON ===");
        // .replace("lama", "baru") mengganti kata tertentu di dalam string
        System.out.println("Replace 'Java' with 'Python': '" + text.replace("Java", "Python") + "'");
        
        // .contains("kata") mengecek apakah string mengandung kata tertentu (mengembalikan true/false)
        System.out.println("Contains 'Programming': " + text.contains("Programming"));
        
        // .startsWith("kata") mengecek apakah string diawali dengan kata tertentu
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        
        // .endsWith("kata") mengecek apakah string diakhiri dengan kata tertentu
        System.out.println("Ends with 'Programming': " + text.endsWith("Programming"));
        
        // Split dan join
        System.out.println("\n=== SPLIT & JOIN ===");
        // .split(" ") memecah string menjadi array berdasarkan pemisah spasi
        String[] words = text.trim().split(" ");
        System.out.println("Number of words: " + words.length);
        System.out.print("Words: ");
        for (String word : words) {
            System.out.print("[" + word + "] ");
        }
        System.out.println();
        
        // StringBuilder untuk efisiensi
        System.out.println("\n=== STRING BUILDER ===");
        // StringBuilder digunakan untuk manipulasi string yang bersifat mutable (bisa diubah tanpa membuat objek baru)
        StringBuilder sb = new StringBuilder();
        sb.append("Java");               // Menambahkan teks di akhir
        sb.append(" Programming");
        sb.insert(0, "Learn ");           // Menyisipkan teks pada indeks ke-0
        sb.reverse();                     // Membalik urutan seluruh karakter
        System.out.println("Reversed: " + sb.toString());
    }
}

/*
Pertanyaan: 
1. Mengapa startsWith("Hello") mengembalikan false? 
Jawab :Karena variabel text diawali dengan karakter spasi (" Hello World! Welcome 
to Java Programming "). Method startsWith("Hello") mengecek karakter persis dari 
indeks ke-0. Karena indeks ke-0 berupa spasi (bukan huruf 'H'), maka hasilnya false
Cara Memperbaikinya:
Jika ingin mengabaikan spasi di awal, kita bisa menggunakan method .trim() 
terlebih dahulu sebelum memanggil .startsWith(), contohnya: text.trim().startsWith
("Hello").
2. Apa perbedaan antara String dan StringBuilder? 
Jawab : String: Bersifat immutable (tidak dapat diubah setelah dibuat). Setiap 
kali kita melakukan modifikasi (seperti penggabungan atau penggantian teks), 
Java akan membuat objek String baru di dalam memori, yang kurang efisien jika 
dilakukan berulang kali.
StringBuilder: Bersifat mutable (dapat diubah-ubah nilainya). Objek ini 
memodifikasi data pada wadah memori yang sama tanpa membuat objek baru, 
sehingga jauh lebih cepat dan efisien untuk operasi manipulasi string yang 
intensif.
3. Bagaimana cara mengambil hanya kata "Java" dari string tersebut? 
Jawab : Ada beberapa cara untuk mengambil kata "Java" dari string tersebut: 
- Menggunakan substring() dengan indeks statis:
// Mencari indeks kata "Java" dimulai dari posisi ke-29
String kataJava = text.substring(29, 33);
- Menggunakan indexOf() agar lebih dinamis:
int start = text.indexOf("Java");
String kataJava = text.substring(start, start + 4);
*/