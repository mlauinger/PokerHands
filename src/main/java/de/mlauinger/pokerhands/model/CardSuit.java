package de.mlauinger.pokerhands.model;

public enum CardSuit {

    HEART("H"),
    DIAMOND("D"),
    SPADE("S"),
    CLUB("C");

    private String symbol;

    CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
