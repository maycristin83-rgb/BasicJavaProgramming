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

class MultipleCatch {
    public static void main(String args[]) {
        int n = args.length;
        int a = 1;
        int c[] = new int[1];
        try {
            if (n == 0)
                a = a / (a - 1);
            else
                c[21] = 5;
        } catch (ArithmeticException e) {
            System.out.println("Ups, seem out we have an Arithmetic "
                    + "Exception here...");
        } catch (Exception e) {
            System.out.println("Let the other exception handler here...");
        }
    }
}

/*
SOAL :
a. Coba eksekusi program tanpa arguments. Catch statement mana yang dieksekusi?
JAWAB :
run:
Ups, seem out we have an Arithmetic Exception here...
BUILD SUCCESSFUL (total time: 0 seconds)
Catch yang dieksekusi adalah catch (ArithmeticException e) (catch pertama). 
Karena n = 0, program menghitung a / (a - 1) yaitu 1/0, yang melempar 
ArithmeticException.

b. Coba eksekusi program dengan sebuah argument. Catch statement mana yang dieksekusi?
JAWAB :
EKSEKUSI TANPA ARGUMENT
run:
Let the other exception handler here...
BUILD SUCCESSFUL (total time: 0 seconds)

Terjadi exception yang berbeda
Array c dibuat dengan new int[1], jadi hanya punya satu elemen, yaitu indeks 0. 
Mengisi c[21] berarti mengakses indeks di luar batas, sehingga Java melempar 
ArrayIndexOutOfBoundsException.

c. Sekarang, ganti ArithmeticException dengan Excception sepeti yang ditunjukkan di
bawah ini:
JAWAB :
Exception in thread "main" java.lang.RuntimeException: Uncompilable code - exception java.lang.ArithmeticException has already been caught
at MultipleCatch.main(MultipleCatch.java:1)
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\MyBook Hype AMD\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 3 seconds)

Program tidak dapat dikompilasi dan muncul error exception ArithmeticException 
has already been caught. Hal ini terjadi karena catch block dicocokkan secara 
berurutan dari atas ke bawah. Exception adalah superclass dari ArithmeticException, 
sehingga catch pertama sudah menangkap semua jenis exception, termasuk 
ArithmeticException. Akibatnya, catch block kedua tidak akan pernah dieksekusi 
(unreachable code), dan kompilator menolaknya.


*/