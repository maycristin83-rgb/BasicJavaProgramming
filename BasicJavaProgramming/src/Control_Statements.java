/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Control_Statements {

    public static void main(String[] args) {

        // ===== 1. If-Then & If-Then-Else Statement =====
        boolean condition = true;
        if (condition) {
            // Block of code to be executed if the condition is true
        }

        int age = 20;
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        }

        if (condition) {
            // Block of code executed if condition is true
        } else {
            // Block of code executed if condition is false
        }

        int age2 = 15;
        if (age2 >= 18) {
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

        // ===== 2. The switch Statement =====
        int month = 8;
        String name;
        switch (month) {
            case 1: name = "January"; break;
            // ...
            case 8: name = "August"; break;
            default: name = "Invalid"; break;
        }
        System.out.println(name);

        // Bisa multi-label
        int month2 = 8;
        int year = 2024;
        int days;
        switch (month2) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31; break;
            case 4: case 6: case 9: case 11: days = 30; break;
            case 2: days = isLeap(year) ? 29 : 28; break;
            default: days = 0; /* handle invalid */
        }
        System.out.println(days);

        // ===== 3. The while and do-while Statements =====
        int i = 1;
        while (i <= 10) { System.out.println(i); i++; }

        int j = 1;
        do { System.out.println(j); j++; } while (j <= 10);

        // ===== 4. The for Statement =====
        for (int k = 1; k <= 10; k++) {
            System.out.println(k);
        }

        // Enhanced for (lebih ringkas untuk array/koleksi)
        int[] nums = {1, 2, 3, 4, 5};
        for (int n : nums) {
            System.out.println(n);
        }

        // ===== 5. Branching Statements =====
        // break (unlabeled)
        int[] a = {32, 87, 3, 589, 12};
        int target = 12;
        int idx = -1;
        for (int x = 0; x < a.length; x++) {
            if (a[x] == target) { idx = x; break; }
        }
        System.out.println(idx);

        // break berlabel
        int[][] m = {{1, 2, 3}, {4, 12, 6}, {7, 8, 9}};
        int target2 = 12;
        boolean found = false;
        search:
        for (int p = 0; p < m.length; p++) {
            for (int q = 0; q < m[p].length; q++) {
                if (m[p][q] == target2) { found = true; break search; }
            }
        }
        System.out.println(found);

        // continue
        int count = 0;
        String s = "peter piper picked...";
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) != 'p') continue;
            count++;
        }
        System.out.println(count);

        // return: contoh pemanggilan method dengan return
        checkNegative(-5);
        System.out.println(incrementCount(count));
    }

    // Helper untuk contoh switch multi-label (cek tahun kabisat)
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Contoh return tanpa nilai (void): "if (x<0) return;"
    static void checkNegative(int x) {
        if (x < 0) return;
        System.out.println("x tidak negatif");
    }

    // Contoh return dengan nilai: "return ++count;" harus cocok tipe hasil method
    static int incrementCount(int count) {
        return ++count;
    }
}