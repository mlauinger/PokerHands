package de.mlauinger.pokerhands.model.hand;

import de.mlauinger.pokerhands.model.card.CardValue;

public class ValueCount extends Count{
    private CardValue value;

    public ValueCount(CardValue value, int count) {
        super(count);
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }
}
