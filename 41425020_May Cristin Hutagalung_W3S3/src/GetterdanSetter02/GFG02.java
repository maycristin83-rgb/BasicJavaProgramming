/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GetterdanSetter02;

/**
 *
 * @author MyBook Hype AMD
 */

// Nama  : May Cristin Hutagalung
// Nim   : 41425020
// Prodi : DIV-Teknologi Rekayasa Perangkat Lunak

class GetSet {
    private int num;
    // Method 1 - Setter
    public void setNumber(int number)
    {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException();
        }
        num = number;
    }
    // Method 2 - Getter
    public int getNumber() { return num; }
}

class GFG02 {
    public static void main(String[] args)
    {
        GetSet obj = new GetSet();
        obj.setNumber(5);
        System.out.println(obj.getNumber());
    }
}
