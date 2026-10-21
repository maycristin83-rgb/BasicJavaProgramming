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

class CaughtExceptionFinally {
    public static void main(String args[]) {
        int n =1;
        try {
            if (n == 0) {
                System.out.println(3/n);
                System.out.println("This won't be executed");
            } else {
                System.out.println("This will be executed if "
                        + "arguments is not zero");
            }
        } catch (Exception e) {
            System.out.println("Catching exception: " + e);
        } finally {
            System.out.println("After trying or catching...");
        }
    }
}

/*
SOAL :
a. Coba eksekusi program di atas tanpa arguments. Apa hasilnya?
jAWAB : run:
Catching exception: java.lang.ArithmeticException: / by zero
After trying or catching...
BUILD SUCCESSFUL (total time: 0 seconds)
b. Coba eksekusi program di atas dengan arguments. Apa hasilnya?
Argument tanpa hasil
run:
This will be executed if arguments is not zero
After trying or catching...
BUILD SUCCESSFUL (total time: 0 seconds)
c. Jelaskan kesimpulan Anda dari pertanyaan a dan b setelah menjalankan program.
JAWAB : Dari percobaan 3a dan 3b dapat disimpulkan bahwa blok finally selalu dieksekusi, 
baik ketika terjadi exception maupun ketika tidak terjadi exception. Pada percobaan 3a, 
program dijalankan tanpa argument sehingga nilai n adalah 0. Pembagian 3/n kemudian 
melempar ArithmeticException, sehingga baris “This won’t be executed” dilewati dan 
program berpindah ke blok catch, lalu dilanjutkan ke blok finally. Pada percobaan 3b, 
program dijalankan dengan argument sehingga nilai n adalah 1 dan program masuk ke 
blok else. Tidak ada exception yang terjadi sehingga blok catch dilewati, tetapi 
blok finally tetap dijalankan. Dengan demikian, blok finally cocok digunakan untuk 
kode yang harus selalu berjalan apa pun kondisinya, misalnya menutup file, koneksi 
database, atau membersihkan resource.

*/
