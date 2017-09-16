package de.mlauinger.pokerhands.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hand {

    private List<Card> cards;
    private HashMap<CardSuit, Integer> suitsInHand;
    private HashMap<CardValue, Integer> valuesInHand;

    public Hand() {
        cards = new ArrayList<Card>();
        initSuitMap();
        initValueMap();
    }

    private void initValueMap() {

    }

    private void initSuitMap() {

    }

}
