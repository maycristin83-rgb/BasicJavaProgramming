package week2.control;

/**
 * Contoh: If-Then & If-Then-Else Statement
 * Slide: "Control Statements"
 */
public class IfElseDemo {
    public static void main(String[] args) {
        int age = 15;
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        int marks = 75;
        if (marks >= 85) {
            System.out.println("Grade A");
        } else if (marks >= 70) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }
    }
}
