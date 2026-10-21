/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
public class ThrowsDemo {
    static void throwOne() {
        System.out.println("I'm throwing a non Runtime exception that I "
                + "don't handle");
        System.out.println("Without specifying in method declaration");
        // IllegalAccessException adalah checked exception,
        // tapi method ini tidak mendeklarasikan "throws"
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        throwOne();
    }
    
}

/*
SOAL :
a. Apa yang akan terjadi jika kode program di atas dieksekusi? Mengapa?
JAWAB :
Yang terjadi dalam code programnya saat dieksekusi adalah :
run:
Exception in thread "main" java.lang.RuntimeException: Uncompilable code - unreported exception java.lang.IllegalAccessException; must be caught or declared to be thrown
	at ThrowsDemo.throwOne(ThrowsDemo.java:1)
	at ThrowsDemo.main(ThrowsDemo.java:21)
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 1 second)
Karena karena IllegalAccessException termasuk checked exception, yaitu exception 
yang wajib ditangani. Method throwOne() melempar exception tersebut tetapi tidak 
menanganinya dengan try-catch dan tidak mendeklarasikannya dengan throws, sehingga 
kompilator menolak kode tersebut.

b. Apa yang akan terjadi jika IllegalAccessException diganti dengan
ArithmeticException? Mengapa? Perbaiki kode program di atas seperti yang
ditunjukkan di bawah ini:
JAWAB :
HASIL RUN NYA ITU :
run:
I'm throwing a non Runtime exception that I don't handle
Without specifying in method declaration
Exception in thread "main" java.lang.ArithmeticException: demo
	at ThrowsDemo.throwOne(ThrowsDemo.java:17)
	at ThrowsDemo.main(ThrowsDemo.java:21)
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 0 seconds)


Setelah diperbaiki, program berjalan normal. Method throwOne() kini mendeklarasikan 
throws IllegalAccessException, sehingga kompilator tahu method ini dapat melempar 
exception tersebut. Pemanggilnya, yaitu main, wajib menangani exception itu, dan di 
sini dilakukan dengan try-catch. Exception yang dilempar kemudian ditangkap dan 
program mencetak “Caught java.lang.IllegalAccessException: demo”.
*/
