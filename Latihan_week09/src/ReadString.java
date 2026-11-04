/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.io .*;

public class ReadString {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Masukkan teks ('stop' untuk berhenti):");
        do {
            str = br.readLine();
           System.out.println("Kamu mengetik: " + str);
        } while (!str.equals("stop"));
    }
}

