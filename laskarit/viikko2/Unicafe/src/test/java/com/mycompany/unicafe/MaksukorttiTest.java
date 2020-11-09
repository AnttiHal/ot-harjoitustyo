package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein() {
        
        
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(200);      
        assertEquals("saldo: 12.0", kortti.toString());
    }
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi() {
        kortti.otaRahaa(800);
        assertEquals("saldo: 2.0", kortti.toString());
    }
    @Test
    public void metodiSaldoPalauttaaOikeanMaaran() {
        
        assertEquals(1000, kortti.saldo());
    }
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(1200);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void josRahatRiittivatPalautaTrue() {
        
        assertTrue(kortti.otaRahaa(1000));      
    }
    @Test
    public void josRahatEiRiitaPalautaFalse() {
        
        assertFalse(kortti.otaRahaa(1200));      
    }
}
