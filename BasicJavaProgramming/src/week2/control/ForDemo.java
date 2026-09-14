package week2.control;

/**
 * Contoh: The for Statement
 * Slide: "Control Statements"
 */
public class ForDemo {
    public static void main(String[] args) {
        // for biasa
        for (int k = 1; k <= 10; k++) {
            System.out.println(k);
        }

        // enhanced for (for-each) -> lebih ringkas untuk array/koleksi
        int[] nums = {1, 2, 3, 4, 5};
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
