package de.mlauinger.pokerhands.model.hand;

import de.mlauinger.pokerhands.logic.CardSuitComparator;
import de.mlauinger.pokerhands.logic.CardValueComparator;
import de.mlauinger.pokerhands.logic.HandRater;
import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.card.CardSuit;
import de.mlauinger.pokerhands.model.card.CardValue;

import java.util.*;

public class Hand {

    private List<Card> cards;
    private List<ValueCount> valueCounts = new ArrayList<>(3);
    private List<SuitCount> suitCounts = new ArrayList<>(4);
    private HandRating rating;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<SuitCount> getSuitCounts() {
        return suitCounts;
    }

    public List<ValueCount> getValueCounts() {
        return valueCounts;
    }

    public int getCount(CardSuit suit) {
        for (SuitCount count : suitCounts) {
            if (count.getValue().equals(suit)) {
                return count.getCount();
            }
        }
        return 0;
    }

    public int getCount(CardValue value) {
        for (ValueCount count : valueCounts) {
            if (count.getValue().equals(value)) {
                return count.getCount();
            }
        }
        return 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        if (!valueCountIncremented(card)) {
            valueCounts.add(new ValueCount(card.getCardValue(), 1));
        }
        if (!suitCountIncremented(card)) {
            suitCounts.add(new SuitCount(card.getCardSuit(), 1));
        }
    }

    private boolean valueCountIncremented(Card card) {
        for (ValueCount count : valueCounts) {
            if (count.getValue().equals(card.getCardValue())) {
                count.increment();
                return true;
            }
        }
        return false;
    }

    private boolean suitCountIncremented(Card card) {
        for (SuitCount count : suitCounts) {
            if (count.getValue().equals(card.getCardSuit())) {
                count.increment();
                return true;
            }
        }
        return false;
    }

    public void addCards(List<Card> cards) {
        cards.forEach(this::addCard);
        suitCounts.sort(new CardSuitComparator());
        valueCounts.sort(new CardValueComparator());
        HandRater.determineRating(this);
    }

    public HandRating getRating() {
        return rating;
    }

    public void setRating(HandRating rating) {
        this.rating = rating;
    }
}
