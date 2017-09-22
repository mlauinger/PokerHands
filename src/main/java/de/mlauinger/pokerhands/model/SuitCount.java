package de.mlauinger.pokerhands.model;

import de.mlauinger.pokerhands.model.card.CardSuit;

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
