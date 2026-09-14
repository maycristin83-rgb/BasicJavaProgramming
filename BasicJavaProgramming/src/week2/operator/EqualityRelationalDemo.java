package week2.operator;

/**
 * Contoh: Operator Equality, Relational, dan Conditional
 * Slide: "Operator dalam Java"
 */
public class EqualityRelationalDemo {
    public static void main(String[] args) {
        // Operator ==, !=, >, <, >=, <= -> hasil boolean
        int a = 5;
        boolean ok = (a == 5); // true
        System.out.println("ok = " + ok);

        // Operator: && (AND), || (OR), ! (NOT)
        boolean r1 = (5 > 3) && (7 < 10); // true
        boolean r2 = (5 < 3) || (7 < 10); // true
        boolean r3 = !(5 > 3);            // false
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);

        // Ternary operator (shorthand if-then-else)
        int nilai = 80;
        String status = (nilai >= 75) ? "Lulus" : "Tidak Lulus";
        System.out.println("status = " + status);

        // instanceof (type comparison operator)
        Object obj = "Hello";
        System.out.println("obj instanceof String = " + (obj instanceof String));
    }
}
