package com.ohlat10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Yksikkötestit kivi-paperi-sakset pelin logiikalle
 */
class PeliTest {

    private Peli peli;

    @BeforeEach
    void alustaPeli() {
        this.peli = new Peli();
    }

    /**
     * Testaa että kivi voittaa sakset pelissä, kummallakin pelaajalla
     */
    @Test
    void testKiviVoittaaSakset() {
        int tulos;
        tulos = peli.ratkaiseKierros(KPS.KIVI, KPS.SAKSET);
        assertEquals(1, tulos);
        tulos = peli.ratkaiseKierros(KPS.SAKSET, KPS.KIVI);
        assertEquals(2, tulos);
    }

    /**
     * Testaa että sakset voittaa paperin pelissä, kummallakin pelaajalla
     */
    @Test
    void testSaksetVoittaaPaperin() {
        int tulos;
        tulos = peli.ratkaiseKierros(KPS.SAKSET, KPS.PAPERI);
        assertEquals(1, tulos);
        tulos = peli.ratkaiseKierros(KPS.PAPERI, KPS.SAKSET);
        assertEquals(2, tulos);
    }

    /**
     * Testaa että paperi voittaa kiven pelissä, kummallakin pelaajalla
     */
    @Test
    void testPaperiVoittaaKiven() {
        int tulos;
        tulos = peli.ratkaiseKierros(KPS.PAPERI, KPS.KIVI);
        assertEquals(1, tulos);
        tulos = peli.ratkaiseKierros(KPS.KIVI, KPS.PAPERI);
        assertEquals(2, tulos);
    }

    /**
     * Testaa tasapelin, kun molemmilla pelaajilla on sama käsi
     */
    @Test
    void testTasapelit() {
        int tulos;
        tulos = peli.ratkaiseKierros(KPS.KIVI, KPS.KIVI);
        assertEquals(0, tulos);
        tulos = peli.ratkaiseKierros(KPS.SAKSET, KPS.SAKSET);
        assertEquals(0, tulos);
        tulos = peli.ratkaiseKierros(KPS.PAPERI, KPS.PAPERI);
        assertEquals(0, tulos);
    }

    /**
     * Testaa pelin kulun alusta loppuun
     * Testille määritetään suoritusaika, jossa testistä tulee suoriutua. Jos testi
     * ei mene läpi annetussa ajassa, voidaan todeta että pelin kulussa on
     * todennäköisesti vikaa
     */
    @Timeout(1)
    @Test
    void testaaPelinKulku() {
        Exception exception = null;

        try {
            peli.pelaa();
        } catch (Exception e) {
            System.err.println(e);
            exception = e;
        }

        assertEquals(null, exception);
    }
}
