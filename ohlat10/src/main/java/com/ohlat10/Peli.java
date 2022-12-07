package com.ohlat10;

/**
 *
 * @author sampopek
 */

public class Peli {
    private Pelaaja p1;
    private Pelaaja p2;
    private KPS p1Valinta;
    private KPS p2Valinta;
    private int pelatutPelit;
    private int tasapelit;
    private boolean peliLoppui;

    /**
     * Pelaa kivi-paperi-sakset peliä, kunnes toinen pelaaja voittaa saavuttamalla 3
     * pistettä
     */
    public void pelaa() {
        alustaPeli();

        do {
            p1Valinta = p1.pelaajanValinta();
            p2Valinta = p2.pelaajanValinta();

            int voittaja = ratkaiseKierros(p1Valinta, p2Valinta);

            String ilmoitus;
            switch (voittaja) {
                case 1:
                    p1.incrementVoitot();
                    ilmoitus = "Pelaaja 1 voittaa";
                    break;
                case 2:
                    p2.incrementVoitot();
                    ilmoitus = "Pelaaja 2 voittaa";
                    break;
                default:
                    tasapelit++;
                    ilmoitus = "Tasapeli!";
            }

            pelatutPelit++;

            ilmoitaKierroksenTiedot(ilmoitus);

            peliLoppui = (p1.getVoitot() >= 3) || (p2.getVoitot() >= 3);

        } while (!peliLoppui);
        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }

    /**
     * Ratkaisee kivi-paperi-sakset pelin voittajan
     * 
     * @param p1Valinta pelaajan 1 valitsema käsi
     * @param p2Valinta pelaajan 2 valitsema käsi
     * @return voittaja, jossa 0 on tasapeli, 1 pelaaja 1 ja 2 pelaaja 2
     */
    public int ratkaiseKierros(KPS p1Valinta, KPS p2Valinta) {
        int voittaja;

        if (p1Valinta.equals(p2Valinta)) {
            voittaja = 0;
        } else {
            switch (p1Valinta) {
                case KIVI:
                    voittaja = p2Valinta.equals(KPS.PAPERI) ? 2 : 1;
                    break;
                case PAPERI:
                    voittaja = p2Valinta.equals(KPS.SAKSET) ? 2 : 1;
                    break;
                case SAKSET:
                    voittaja = p2Valinta.equals(KPS.KIVI) ? 2 : 1;
                    break;
                default:
                    voittaja = 0;
            }
        }
        return voittaja;
    }

    /**
     * Tulostaa konsoliin kierroksen tiedot
     * 
     * @param ilmoitus teksti jossa voidaan kertoa voittaja tai tasapeli
     */
    private void ilmoitaKierroksenTiedot(String ilmoitus) {
        System.out.println("Erä: " + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
        System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
        System.out.println(ilmoitus);
    }

    /**
     * Alustaa pelissä tarvittavat muuttujat ja Pelaaja-oliot.
     */
    private void alustaPeli() {
        p1 = new Pelaaja();
        p2 = new Pelaaja();
        pelatutPelit = 0;
        tasapelit = 0;
        peliLoppui = false;
    }
}
