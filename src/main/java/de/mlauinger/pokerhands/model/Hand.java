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

}
