package de.mlauinger.pokerhands.model.card;

import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;

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
    JACK("J"),
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

    public static CardValue parseValue(final String input) throws InvalidInputException {
        for (CardValue value : CardValue.values()) {
            if(value.symbol.equals(input)) {
                return value;
            }
        }
        throw new InvalidInputException();
    }

}
