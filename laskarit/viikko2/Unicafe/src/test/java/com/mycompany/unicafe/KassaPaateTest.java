/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anttihalmetoja
 */
public class KassaPaateTest {
    Kassapaate paate;  
    Maksukortti kortti;
    public KassaPaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kassassaRahaaOikeaSummaluomisenJalkeen() {
        
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Test
    public void luomisenJalkeenMyytyjaLounaitaNolla() {
        
        assertEquals(0, paate.maukkaitaLounaitaMyyty()+paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKateisellaKasvattaaKassanSaldoaOikeinJosMaksuRiittava() {
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());        
    }
    @Test
    public void syoEdullisestiKateisellaPalauttaaOikeinVaihtorahanJosMaksuRiittava() {        
        assertEquals(160, paate.syoEdullisesti(400));        
    }
    @Test
    public void syoMaukkaastiKateisellaKasvattaaKassanSaldoaOikeinJosMaksuRiittava() {
        paate.syoMaukkaasti(400);
        assertEquals(100400, paate.kassassaRahaa());        
    }
    @Test
    public void syoMaukkaastiKateisellaPalauttaaOikeinVaihtorahanJosMaksuRiittava() {        
        assertEquals(200, paate.syoMaukkaasti(600));        
    }
    @Test
    public void maukkaidenLounaidenMaaraKasvaaJosMaksuRiittava() {   
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());        
    }
    public void edullistenLounaidenMaaraKasvaaJosMaksuRiittava() {   
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());        
    }
    @Test
    public void syoEdullisestiKateisellaEiKasvataKassanSaldoaJosMaksuEiRiittava() {
        paate.syoEdullisesti(100);
        assertEquals(100000, paate.kassassaRahaa());        
    }
    @Test
    public void syoMaukkaastiKateisellaEiKasvataKassanSaldoaJosMaksuEiRiittava() {
        paate.syoMaukkaasti(100);
        assertEquals(100000, paate.kassassaRahaa());        
    }
    @Test
    public void syoEdullisestiKateisellaPalauttaakokoSummanVaihtorahanaJosMaksuEiRiittava() {
        paate.syoEdullisesti(100);
        assertEquals(100, paate.syoEdullisesti(100));        
    }
    @Test
    public void syoMaukkaastiKateisellaPalauttaakokoSummanVaihtorahanaJosMaksuEiRiittava() {
        paate.syoMaukkaasti(100);
        assertEquals(100, paate.syoMaukkaasti(100));        
    }
    @Test
    public void syoEdullisestiKateisellaEiMuutaMaukkaidenLounaidenMyyntimaaraaJosMaksuEiRiittava() {
        paate.syoEdullisesti(100);
        assertEquals(0, paate.edullisiaLounaitaMyyty());        
    }
    @Test
    public void syoMaukkaastiKateisellaEiMuutaMaukkaidenLounaidenMyyntimaaraaJosMaksuEiRiittava() {
        paate.syoMaukkaasti(100);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());        
    }
    @Test
    public void syoMaukkaastiKortillaPalauttaaTrueJosKortillaTarpeeksiRahaa() {
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.syoMaukkaasti(kortti));      
    }
    @Test
    public void syoEdullisestiKortillaPalauttaaTrueJosKortillaTarpeeksiRahaa() {
        paate.syoEdullisesti(kortti);
        assertTrue(paate.syoEdullisesti(kortti));      
    }
    @Test
    public void myytyjenMaukkaidenlounaidenMaaraKasvaaJosKortillaTarpeeksiRahaa() {
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());     
    }
    @Test
    public void myytyjenEdullistenlounaidenMaaraKasvaaJosKortillaTarpeeksiRahaa() {
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoMaukkaastiKortillaPalauttaaFalseJosKortillaEiTarpeeksiRahaa() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        
        assertFalse(paate.syoMaukkaasti(kortti));      
    }
    @Test
    public void syoEdullisestiKortillaPalauttaaFalseJosKortillaEiTarpeeksiRahaa() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertFalse(paate.syoEdullisesti(kortti));      
    }
    @Test
    public void myytyjenMaukkaidenlounaidenMaaraEiKasvaJosKortillaEiTarpeeksiRahaa() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());     
    }
    @Test
    public void myytyjenEdullistenlounaidenMaaraEiKasvaJosKortillaTarpeeksiRahaa() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(4, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKortillaEiPienennaKortinSaldoaJosKortillaEiTarpeeksiRahaa() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(40, kortti.saldo());      
    }
    @Test
    public void syoMaukkaastiKortillaEiPienennaKortinSaldoaJosKortillaEiTarpeeksiRahaa() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());      
    }
    @Test
    public void syoMaukkaastiKortillaEiKasvataKassanSaldoa() {
        paate.syoMaukkaasti(kortti);
        
        assertEquals(100000, paate.kassassaRahaa());      
    }
    @Test
    public void syoEdullisestiKortillaEiKasvataKassanSaldoa() {
        paate.syoEdullisesti(kortti);
        
        assertEquals(100000, paate.kassassaRahaa());      
    }
    @Test
    public void kortilleRahaaLadattaessaKortinSaldoMuuttuu() {
        paate.lataaRahaaKortille(kortti, 100);
        
        assertEquals(1100, kortti.saldo());      
    }
    @Test
    public void kortilleRahaaLadattaessaKassanSummaKasvaaOikein() {
        paate.lataaRahaaKortille(kortti, 100);
        
        assertEquals(100100, paate.kassassaRahaa());      
    }
    @Test
    public void kortilleRahaaLadattaessaEiTuleMuutostaJosLadattavaSummaNegatiivinen() {
        paate.lataaRahaaKortille(kortti, -1);
        
        assertEquals(100000, paate.kassassaRahaa());      
    }
}
