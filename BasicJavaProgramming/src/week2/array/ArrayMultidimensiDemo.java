package week2.array;

/**
 * Contoh: Array Multidimensi
 * Slide: "Array dalam Java"
 *
 * - Array di dalam array (contoh: String[][]).
 * - Setiap baris bisa memiliki panjang berbeda (berbeda dari C/Fortran).
 */
public class ArrayMultidimensiDemo {
    public static void main(String[] args) {
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };

        System.out.println(names[0][0] + names[1][0]); // Mr. Smith
        System.out.println(names[0][2] + names[1][1]); // Ms. Jones
    }
}
