package week2.operator;

/**
 * Contoh: Operator dalam Java (Assignment, Arithmetic, Unary)
 * Slide: "Operator dalam Java"
 */
public class ArithmeticUnaryDemo {
    public static void main(String[] args) {
        // Arithmetic operators
        int sum = 3 + 4;      // 7
        int diff = 10 - 3;    // 7
        int prod = 7 * 3;     // 21
        double q = 20.0 / 3;  // 6.666...
        int r = 7 % 3;        // 1

        System.out.println("sum  = " + sum);
        System.out.println("diff = " + diff);
        System.out.println("prod = " + prod);
        System.out.println("q    = " + q);
        System.out.println("r    = " + r);

        // Compound assignment: +=, -=, *=, /=, %=
        int x = 10;
        x += 5; // x = 15
        System.out.println("x (compound assignment) = " + x);

        // Dampak tipe data
        double d = 10.0 / 3; // 3.333...
        int i = 10 / 3;      // 3 (truncation)
        System.out.println("d = " + d + " , i = " + i);

        // Math utility
        double p = Math.pow(2, 3); // 8.0
        double s = Math.sqrt(64);  // 8.0
        System.out.println("Math.pow(2,3) = " + p);
        System.out.println("Math.sqrt(64) = " + s);

        // Unary operators
        int a = 5;
        int b = -a;   // unary minus
        int c = a++;  // post-increment
        int e = ++a;  // pre-increment
        boolean flag = false;
        System.out.println("b = " + b + ", c = " + c + ", e = " + e + ", !flag = " + (!flag));
    }
}
