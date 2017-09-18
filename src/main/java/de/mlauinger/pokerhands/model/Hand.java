package de.mlauinger.pokerhands.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hand {

    private List<Card> cards;
    private HashMap<CardSuit, Integer> suitsInHand;
    private HashMap<CardValue, Integer> valuesInHand;

    public Hand() {
        cards = new ArrayList<>();
        initSuitMap();
        initValueMap();
    }

    private void initValueMap() {
        valuesInHand = new HashMap<>();
        Arrays.asList(CardValue.values()).forEach(value -> {
            valuesInHand.put(value, 0);
        });
    }

    private void initSuitMap() {
        suitsInHand = new HashMap<>();
        Arrays.asList(CardSuit.values()).forEach(suit -> {
            suitsInHand.put(suit, 0);
        });
    }

    public int getCount(CardSuit suit) {
        return suitsInHand.get(suit);
    }

    public int getCount(CardValue value) {
        return valuesInHand.get(value);
    }

    public void addCard(Card card) {
        cards.add(card);
        incrementCounts(card);
    }

    private void incrementCounts(Card card) {
        suitsInHand.put(card.getCardSuit(), suitsInHand.get(card.getCardSuit()) + 1);
        valuesInHand.put(card.getCardValue(), valuesInHand.get(card.getCardValue()) + 1);
    }

    public void addCards(List<Card> cards) {
        cards.forEach(card -> addCard(card));
    }
}
