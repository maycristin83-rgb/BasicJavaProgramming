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

public class HandlingException {
    public static void main(String[] args) {
        try {
            System.out.println(3/0);
        } catch (ArithmeticException ex) {
            System.out.println("Error " + ex);
        }
    }
}

/*
SOAL :
a. Ganti ex dengan ex.getMessage() dan ex.getStackTrace(). 
Coba juga untuk mengeksekusi statement ex.printStackTrace() dan lihat apa hasilnya. 
JAWAB : 
 - Saat kita mengganti ex menjadi ex.getMessage()
Hasil run nya itu
Error / by zero
BUILD SUCCESSFUL (total time: 0 seconds)

- Saat kita memakai ex.getMessage()
Hasil nya itu 
run:
Error [Ljava.lang.StackTraceElement;@10f87f48
BUILD SUCCESSFUL (total time: 0 seconds)

- Menggunakan ex.printStackTrace()
Hasil run nya :
run:
java.lang.ArithmeticException: / by zero
	at HandlingException.main(HandlingException.java:20)
BUILD SUCCESSFUL (total time: 0 seconds)


b. Ganti AtirhmeticException dengan Exception. Apa hasilnya? Jelaskan. 
JAWAB : 
Hasil run :
run:
Error java.lang.ArithmeticException: / by zero
BUILD SUCCESSFUL (total time: 0 seconds)

Exception adalah superclass (kelas induk) dari ArithmeticException. Karena itu, 
catch (Exception ex) tetap cocok dan menangkap exception pembagian dengan nol. 
Ini contoh polimorfisme: objek ArithmeticException bisa ditampung oleh variabel 
bertipe Exception.
PERBEDAANNYA :
catch (ArithmeticException ex) hanya menangkap exception aritmetika.
catch (Exception ex) lebih umum dan menangkap hampir semua jenis exception.
*/
