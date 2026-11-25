/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/*
Nim   : 41425020
Nama  : May Cristin Hutagalung
Prodi : DIV-teknologi Rekayasa Perangkat Lunak
*/

package com.praktikum.kupon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class KuponTest {

    private Kupon kupon;

    // Dijalankan sebelum SETIAP test, supaya tiap test mulai dari objek yang bersih
    // Kupon HEMAT10: diskon 10%, kuota 5, minimal belanja 50.000
    @BeforeEach
    void setUp() {
        kupon = new Kupon("HEMAT10", 10, 5, 50000.0);
    }

    // ===================== 2 KASUS NORMAL =====================

    @Test
    void konstruktor_dataValid_nilaiTersimpanBenar() {
        assertEquals("HEMAT10", kupon.getKode());
        assertEquals(10, kupon.getPersentase());
        assertEquals(5, kupon.getKuota());
        assertEquals(50000.0, kupon.getMinBelanja(), 0.001);
    }

    @Test
    void hitungDiskon_totalDiAtasMinimal_diskonBenar() {
        // 10% dari 100.000 = 10.000
        assertEquals(10000.0, kupon.hitungDiskon(100000.0), 0.001);
    }

    // ===================== 2 KASUS BATAS =====================

    @Test
    void konstruktor_persentaseBatas1Dan100_diperbolehkan() {
        // Batas bawah dan batas atas persentase masih valid
        assertEquals(1, new Kupon("MIN", 1, 1, 0).getPersentase());
        assertEquals(100, new Kupon("MAX", 100, 1, 0).getPersentase());
    }

    @Test
    void hitungDiskon_totalTepatMinimal_berhasil() {
        // Total sama persis dengan minimal belanja harus tetap diterima
        assertEquals(5000.0, kupon.hitungDiskon(50000.0), 0.001);
    }

    // ===================== 2 EXCEPTION =====================

    @Test
    void pakai_kuotaHabis_melemparIllegalState() {
        Kupon habis = new Kupon("HABIS", 5, 0, 0);
        assertTrue(habis.isHabis());
        assertThrows(IllegalStateException.class, habis::pakai);
    }

    @Test
    void hitungDiskon_totalDiBawahMinimal_melemparIllegalArgument() {
        // 49.999 kurang 1 dari batas minimal 50.000
        assertThrows(IllegalArgumentException.class,
                () -> kupon.hitungDiskon(49999.0));
    }

    // ===================== TEST TAMBAHAN =====================

    @Test
    void pakai_kuotaTerakhir_menjadiHabis() {
        Kupon satu = new Kupon("SATU", 10, 1, 0);
        satu.pakai();
        assertEquals(0, satu.getKuota());
        assertTrue(satu.isHabis());
    }

    @Test
    void tambahKuota_jumlahNol_melemparIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> kupon.tambahKuota(0));
    }

    // Test untuk bug yang ditemukan: kuota maksimum ditambah 1 harus ditolak, bukan jadi negatif
    @Test
    void tambahKuota_overflow_melemparArithmeticException() {
        Kupon penuh = new Kupon("PENUH", 10, Integer.MAX_VALUE, 0);
        assertThrows(ArithmeticException.class, () -> penuh.tambahKuota(1));
    }

    // ===================== PARAMETERIZED TEST =====================

    // Menguji banyak kode tidak valid sekaligus: null, "", " ", "   "
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void konstruktor_kodeTidakValid_melemparIllegalArgument(String kodeTidakValid) {
        assertThrows(IllegalArgumentException.class,
                () -> new Kupon(kodeTidakValid, 10, 1, 0));
    }

    // Menguji persentase di luar rentang 1..100 (termasuk nilai tepat di luar batas)
    @ParameterizedTest
    @ValueSource(ints = {0, -5, 101, 1000})
    void konstruktor_persentaseDiLuarRentang_melemparIllegalArgument(int persen) {
        assertThrows(IllegalArgumentException.class,
                () -> new Kupon("X", persen, 1, 0));
    }

    // Menguji hitungDiskon dengan beberapa variasi total (persentase 10%)
    @ParameterizedTest
    @CsvSource({
        "50000.0, 5000.0",
        "100000.0, 10000.0",
        "250000.0, 25000.0"
    })
    void hitungDiskon_variasiTotal_hasilSesuai(double total, double diharapkan) {
        assertEquals(diharapkan, kupon.hitungDiskon(total), 0.001);
    }
}

/*
package com.praktikum.kupon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MyBook Hype AMD
 
public class KuponTest {
    
    public KuponTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getKode method, of class Kupon.
     
    @Test
    public void testGetKode() {
        System.out.println("getKode");
        Kupon instance = null;
        String expResult = "";
        String result = instance.getKode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersentase method, of class Kupon.
     
    @Test
    public void testGetPersentase() {
        System.out.println("getPersentase");
        Kupon instance = null;
        int expResult = 0;
        int result = instance.getPersentase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKuota method, of class Kupon.
     
    @Test
    public void testGetKuota() {
        System.out.println("getKuota");
        Kupon instance = null;
        int expResult = 0;
        int result = instance.getKuota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinBelanja method, of class Kupon.
     
    @Test
    public void testGetMinBelanja() {
        System.out.println("getMinBelanja");
        Kupon instance = null;
        double expResult = 0.0;
        double result = instance.getMinBelanja();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pakai method, of class Kupon.
     
    @Test
    public void testPakai() {
        System.out.println("pakai");
        Kupon instance = null;
        instance.pakai();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tambahKuota method, of class Kupon.
    
    @Test
    public void testTambahKuota() {
        System.out.println("tambahKuota");
        int jumlah = 0;
        Kupon instance = null;
        instance.tambahKuota(jumlah);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hitungDiskon method, of class Kupon.
     
    @Test
    public void testHitungDiskon() {
        System.out.println("hitungDiskon");
        double total = 0.0;
        Kupon instance = null;
        double expResult = 0.0;
        double result = instance.hitungDiskon(total);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHabis method, of class Kupon.
    
    @Test
    public void testIsHabis() {
        System.out.println("isHabis");
        Kupon instance = null;
        boolean expResult = false;
        boolean result = instance.isHabis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
*/
