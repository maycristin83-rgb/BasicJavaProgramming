package week2.nonprimitive;

/**
 * Contoh: Tipe Data Non-Primitive - Class
 * Slide: "Tipe Data Non-Primitive"
 *
 * Class adalah cetak biru (blueprint) untuk membuat objek,
 * berisi atribut (field) & perilaku (method).
 */
public class Demo {
    int a, b;

    Demo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int addition() {
        return a + b;
    }

    public static void main(String[] args) {
        Demo d = new Demo(5, 7);
        System.out.println("Hasil penjumlahan = " + d.addition());

        // Contoh String sebagai objek (bukan primitive)
        String s1 = "Hello";
        String s2 = new String("Java");
        System.out.println(s1 + " " + s2);
    }
}
