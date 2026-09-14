package week2.operator;

/**
 * Contoh: Bitwise and Bit Shift Operators
 * Slide: "Operator dalam Java"
 */
public class BitwiseDemo {
    public static void main(String[] args) {
        int and = 5 & 3;  // 1
        int or  = 5 | 3;  // 7
        int xor = 5 ^ 3;  // 6

        System.out.println("5 & 3 = " + and);
        System.out.println("5 | 3 = " + or);
        System.out.println("5 ^ 3 = " + xor);

        System.out.println("~5 (complement) = " + (~5));
        System.out.println("5 << 1 (left shift) = " + (5 << 1));
        System.out.println("5 >> 1 (right shift) = " + (5 >> 1));
        System.out.println("-5 >>> 1 (unsigned right shift) = " + (-5 >>> 1));
    }
}
