/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObjekfinalize;

/**
 *
 * @author MyBook Hype AMD
 */

//Nim   :   41425020
//Nama  :   May Cristin Hutagalung //
//Prodi :   DIV-Teknologi Rekayasa Perangkat Lunak /


public class Geeks {
    public static void main(String[] args) {
        Geeks t = new Geeks();
        System.out.println(t.hashCode());

        t = null;

        System.gc();

        System.out.println("end");
    }

    @Override
    protected void finalize()
    {
        System.out.println("finalize method called");
    }
}