package de.mlauinger.pokerhands.model;

public class Card {

    private CardSuit cardSuit;
    private CardValue cardValue;

    public Card(String suitString, String valueString) {
        this.cardSuit = CardSuit.valueOf(suitString);
        this.cardValue = CardValue.valueOf(valueString);
    }

}
