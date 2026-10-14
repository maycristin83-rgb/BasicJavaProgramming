/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package del.ac.id.anakan;

/**
 *
 * @author MyBook Hype AMD
 */


import del.ac.id.induk.Kendaraan;

public class Mobil extends Kendaraan {
    private int jlhTorsi, faktorPembagi;
    private float panjangGagang, rasioGigi;

    public Mobil() {}

    protected void setJlhTorsi(int value) { jlhTorsi = value; }
    protected void setPanjangGagang(float value) { panjangGagang = value; }
    protected void setRasioGigi(float value) { rasioGigi = value; }
    protected void setFaktorPembagi(int value) { faktorPembagi = value; }

    @Override
    protected float kalkulasiPercepatan(int jlhTorsi, float panjangGagang, float rasioGigi) {
        return super.kalkulasiPercepatan(jlhTorsi, panjangGagang, rasioGigi) * faktorPembagi;
    }

    @Override
    protected void cetakInformasi(Object o) {
        System.out.println("=====================================================");
        System.out.println(String.format("Mobil saya berwarna %s.", ((Mobil) o).getWarnaKendaraan()));
        System.out.println(String.format("Dimensi mobil tersebut adalah %d meter persegi", ((Mobil) o).getDimensiKendaraan()));
        System.out.println(String.format("dan dengan percepatan sekitar %.2f km/jam.",
                kalkulasiPercepatan(jlhTorsi, panjangGagang, rasioGigi)));
        System.out.println(String.format("Motor tersebut memiliki %d kaca spion dan %d roda. ",
                ((Mobil) o).getJlhSpion(), ((Mobil) o).getJlhRoda()));
        System.out.println("=====================================================");
    }
}