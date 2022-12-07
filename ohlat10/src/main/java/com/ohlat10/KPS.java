package com.ohlat10;

/**
 * kivi-paperi-sakset pelissä käytettävät kädet
 */
public enum KPS {
    KIVI("kivi"),
    PAPERI("paperi"),
    SAKSET("sakset");

    public final String label;

    private KPS(String label) {
        this.label = label;
    }
}
