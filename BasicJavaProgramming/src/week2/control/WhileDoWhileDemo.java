package week2.control;

/**
 * Contoh: The while and do-while Statements
 * Slide: "Control Statements"
 *
 * - while  : cek kondisi di awal, bisa 0 kali eksekusi.
 * - do-while: cek kondisi di akhir, pasti eksekusi >= 1 kali.
 */
public class WhileDoWhileDemo {
    public static void main(String[] args) {
        // while
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // do-while
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while (j <= 10);
    }
}
