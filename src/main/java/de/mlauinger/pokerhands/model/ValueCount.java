package de.mlauinger.pokerhands.model;

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
