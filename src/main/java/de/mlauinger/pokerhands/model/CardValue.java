package de.mlauinger.pokerhands.model;

public enum CardValue {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JOKER("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String symbol;

    CardValue(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
