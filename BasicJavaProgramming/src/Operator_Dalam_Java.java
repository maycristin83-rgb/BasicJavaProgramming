/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Operator_Dalam_Java {

    public static void main(String[] args) {
        // Contoh penggunaan operator
        int sum = 3 + 4;        // 7
        int diff = 10 - 3;      // 7
        int prod = 7 * 3;       // 21
        double q = 20.0 / 3;    // 6.666...
        int r = 7 % 3;          // 1

        System.out.println(sum);
        System.out.println(diff);
        System.out.println(prod);
        System.out.println(q);
        System.out.println(r);

        // Compound assignment: +=, -=, *=, /=, %=
        int x = 10;
        x += 5; // x = 15
        System.out.println(x);

        //Dampak tipe data:
        double d = 10.0 / 3;  // 3.333...
        int i = 10 / 3;       // 3 (truncation)
        System.out.println(d);
        System.out.println(i);

        //Pada ekspresi campuran, tipe lebih kecil dipromosikan
        //(mis. int -> double). Math utility:
        double p = Math.pow(2, 3);  // 8.0
        double s = Math.sqrt(64);   // 8.0
        System.out.println(p);
        System.out.println(s);

        //Operator == != > < >= <= -> hasil boolean.
        int a = 5;
        boolean ok = (a == 5); // true
        System.out.println(ok);

        //Operator: && (AND), || (OR), ! (NOT)
        boolean r1 = (5 > 3) && (7 < 10); // true
        boolean r2 = (5 < 3) || (7 < 10); // true
        boolean r3 = !(5 > 3);            // false
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //Operator: Bitwise (untuk integer): & | ^ ~ << >>
        int and = 5 & 3; // 1
        int or  = 5 | 3; // 7
        int xor = 5 ^ 3; // 6
        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
    }
}