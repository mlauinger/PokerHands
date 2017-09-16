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

    public static CardSuit parseValue(final String input) throws InvalidInputException {
        for (CardSuit suit : CardSuit.values()) {
            if(suit.symbol.equals(input)) {
                return suit;
            }
        }
        throw new InvalidInputException();
    }

}
