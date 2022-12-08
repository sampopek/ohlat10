package com.ohlat10;

/**
 * Kivi-paperi-sakset pelissä käytettävä pelaaja. Arpoo pelaajalle
 * pelissä
 * käytettävän käden ja pitää kirjaa voitoista.
 * 
 * @author sampopek
 */
public class Pelaaja {

    private int voitot; // Voittojen lukumäärä

    /**
     * Valitse pelaajalle pseudosatunnaisesti {@link KPS}
     * 
     * @return palauttaa kivi-paperi-sakset käden {@link KPS}
     */
    public KPS pelaajanValinta() {
        KPS valinta;
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = KPS.KIVI;
                break;
            case 1:
                valinta = KPS.PAPERI;
                break;
            default:
                valinta = KPS.SAKSET;
                break;
        }
        return valinta;
    }

    /**
     * Kasvattaa voitot muuttujaa yhdellä
     */
    public void incrementVoitot() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voitot
     * 
     * @return pelaajan voitot
     */
    public int getVoitot() {
        return voitot;
    }
}
