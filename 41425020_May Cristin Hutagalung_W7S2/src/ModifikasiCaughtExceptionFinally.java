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

public class ModifikasiCaughtExceptionFinally {
    public static void main(String args[]) {
        int n = args.length;
        try {
            if (n == 0) {
                System.out.println(3/n);
                System.out.println("This won't be executed");
            } else {
                System.out.println("This will be executed if "
                        + "arguments is not zero");
            }
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        } finally {
            System.out.println("After trying or catching...");
        }
    }
}

/* SOAL

Modifikasi kode program no.3. Ganti Exception di dalam catch block dengan
NullPointerException. Eksekusi dan jalankan kode. Apa hasilnya dan jelaskan apa yang
terjadi jika sebuah exception tidak memiliki sebuah catch yang cocok?

JAWAB :
After trying or catching...
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at ModifikasiCaughtExceptionFinally.main(ModifikasiCaughtExceptionFinally.java:22)
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 0 seconds)

Hasilnya, program tetap mencetak “After trying or catching...” dari blok finally, 
lalu berhenti dengan pesan Exception in thread "main" java.lang.ArithmeticException: 
/ by zero. Hal ini terjadi karena exception yang muncul adalah ArithmeticException akibat 3/0, 
sedangkan catch block hanya menangkap NullPointerException, sehingga tidak ada catch yang cocok.
*/