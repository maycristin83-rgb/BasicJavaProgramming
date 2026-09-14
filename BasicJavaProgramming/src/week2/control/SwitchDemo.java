package week2.control;

/**
 * Contoh: The switch Statement
 * Slide: "Control Statements"
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int month = 8;
        String name;
        switch (month) {
            case 1: name = "January"; break;
            // ...
            case 8: name = "August"; break;
            default: name = "Invalid"; break;
        }
        System.out.println("name = " + name);

        // Multi-label switch: menentukan jumlah hari dalam bulan
        int year = 2024;
        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; break;
            case 4: case 6: case 9: case 11:
                days = 30; break;
            case 2:
                days = isLeap(year) ? 29 : 28; break;
            default:
                days = -1; // handle invalid
        }
        System.out.println("days = " + days);
    }

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
