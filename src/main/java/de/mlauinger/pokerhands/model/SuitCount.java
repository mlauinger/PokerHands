package de.mlauinger.pokerhands.model;

public class SuitCount extends Count {
    private CardSuit value;

    public SuitCount(CardSuit value, int count) {
        super(count);
        this.value = value;
    }

    public CardSuit getValue() {
        return value;
    }
}
