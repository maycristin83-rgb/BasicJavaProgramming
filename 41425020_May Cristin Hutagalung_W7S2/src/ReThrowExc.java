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

public class ReThrowExc { // Method ini melempar exception, menangkapnya, lalu melemparnya lagi
    static void demoThrow() {
        try {
            System.out.println("I'm throwing an exception from demoThrow "
                    + "method"); // Melempar NullPointerException secara manual
            throw new NullPointerException("demo");
        } catch (NullPointerException e) { // Exception ditangkap di dalam demoThrow
            System.out.println("I'm catching the exception [" + e + "]");
            System.out.println("But I'll throw it again...\n");
            // "throw e" melempar ulang exception yang sama ke pemanggil
            // (method main). Tanpa baris ini, main tidak akan tahu ada exception.
            throw e;
        }
    }

    public static void main(String args[]) {
        try {
            // Memanggil demoThrow, yang akan melempar ulang exception
            demoThrow();
        } catch (NullPointerException e) {
            // Exception yang dilempar ulang dari demoThrow ditangkap di sini
            System.out.println("I'm catching the exception [" + e + "]\n "
                    + "thrown from demoThrow method");
        }
    }  
}

/*
SOAL :
a. Jika exception e tidak dilempar (rethrown) dari method demoThrow, apakah masih
akan di tangkap dari dalam main function?
JAWAB :
HASIL RUN :
run:
I'm throwing an exception from demoThrow method
I'm catching the exception [java.lang.NullPointerException: demo]
But I'll throw it again...

BUILD SUCCESSFUL (total time: 0 seconds)

Tidak. Jika throw e; dihapus, exception sudah dianggap selesai ditangani di 
dalam demoThrow, sehingga tidak ada exception yang sampai ke main dan catch di 
main tidak dieksekusi. Program berjalan normal sampai selesai.

b. Apa yang bisa Anda simpulkan dari kode program di atas?
JAWAB :
Dari program di atas dapat disimpulkan bahwa sebuah exception yang sudah ditangkap 
dalam suatu catch block dapat dilempar kembali (re-throw) menggunakan throw e, 
sehingga method pemanggilnya juga dapat menangkap dan menanganinya. Hal ini 
berguna ketika sebuah method hanya ingin melakukan penanganan sebagian, misalnya 
mencatat pesan atau log, lalu menyerahkan penanganan akhir kepada method yang memanggilnya.
*/