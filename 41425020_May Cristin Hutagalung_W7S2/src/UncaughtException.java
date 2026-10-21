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

public class UncaughtException {
    public static void main(String args[]) {
        System.out.println(3/0);
    }
 
}

/*
SOAL :

a. Analisis apa yang akan terjadi ketika program di atas di eksekusi.
JAWAB : /0 adalah pembagian integer dengan nol, sehingga JVM melempar 
ArithmeticException. Karena tidak ada try-catch, exception tidak tertangani 
(uncaught). Exception naik sampai ke main, lalu JVM menghentikan program dan 
mencetak stack trace.

b. Apa outputnya? 
JAWAB :Hasil nya
Exception in thread "main" java.lang.ArithmeticException: / by zero
at UncaughtException.main(UncaughtException.java:19)
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 0 seconds)
*/