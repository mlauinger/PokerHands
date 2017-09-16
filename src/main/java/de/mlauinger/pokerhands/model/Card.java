package de.mlauinger.pokerhands.model;

public class Card {

    private CardSuit cardSuit;
    private CardValue cardValue;

    public Card(String suitString, String valueString) throws InvalidInputException {
        this.cardSuit = CardSuit.parseValue(suitString);
        this.cardValue = CardValue.parseValue(valueString);
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }
}
