/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */

import java.io.*;
public class ShowFile {
    public static void main(String[] args) throws IOException {
        int i;
        try (FileInputStream fin = new FileInputStream("input.txt")) {
            do {
                i = fin.read();
                if (i !=- 1) System.out.print((char) i);
            } while (i != -1);
            } catch (FileNotFoundException e) {
                 System.out.println("File tidak ditemukan!");
        }
    }
}
