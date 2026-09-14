package week2.control;

/**
 * Contoh: Branching Statements (break, continue, return)
 * Slide: "Control Statements"
 */
public class BranchingDemo {
    public static void main(String[] args) {
        // break (unlabeled) -> keluar dari loop terdekat
        int[] a = {32, 87, 3, 589, 12};
        int target = 12;
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                idx = i;
                break;
            }
        }
        System.out.println("idx = " + idx);

        // break berlabel -> keluar dari outer loop tertentu
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int cariTarget = 5;
        boolean found = false;
        search:
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == cariTarget) {
                    found = true;
                    break search;
                }
            }
        }
        System.out.println("found = " + found);

        // continue -> lewati iterasi saat ini, lanjut ke berikutnya
        int count = 0;
        String s = "peter piper picked...";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'p') continue;
            count++;
        }
        System.out.println("count huruf p = " + count);

        // return
        System.out.println("hasil method = " + tambahJikaPositif(5, -1));
    }

    static int tambahJikaPositif(int x, int y) {
        if (x < 0) return 0;
        return x + y; // harus cocok dengan tipe hasil method
    }
}
