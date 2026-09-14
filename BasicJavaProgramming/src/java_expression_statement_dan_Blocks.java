/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class java_expression_statement_dan_Blocks {

    public static void main(String[] args) {

        // ===== 1. Expressions =====
        int result = 1 + 2;          // menghasilkan int
        System.out.println(result);

        int a = 5, b = 5;
        if (a == b) System.out.println("Sama"); // menghasilkan boolean

        // ===== 2. Statement =====
        // Declaration statement : deklarasi variabel
        double aValue = 8933.234;

        // Expression statement : hasil ekspresi yang diakhiri ;
        aValue = 8933.234;          // assignment
        aValue++;                   // increment
        System.out.println(aValue); // method call
        // new Bicycle();           // object creation (class Bicycle tidak tersedia)

        // ===== 3. Blocks =====
        // Sekumpulan statement diapit { ... }
        boolean condition = true;
        if (condition) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}