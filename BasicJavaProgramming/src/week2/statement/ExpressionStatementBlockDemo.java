package week2.statement;

/**
 * Contoh: Expression, Statement, dan Blocks
 * Slide: "Java : Expression, Statement, dan Blocks"
 */
public class ExpressionStatementBlockDemo {
    public static void main(String[] args) {
        // 1. Expression -> menghasilkan 1 nilai
        int result = 1 + 2; // menghasilkan int
        boolean a = true, b = true;
        if (a == b) {
            System.out.println("Sama"); // menghasilkan boolean pada kondisi
        }
        System.out.println("result = " + result);

        // 2. Statement
        double aValue = 8933.234; // declaration statement
        aValue = 8933.234;        // expression statement: assignment
        aValue++;                  // expression statement: increment
        System.out.println(aValue); // expression statement: method call

        // 3. Blocks -> sekumpulan statement diapit { }
        boolean condition = true;
        if (condition) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
