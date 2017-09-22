package de.mlauinger.pokerhands.model;

import de.mlauinger.pokerhands.logic.CardSuitComparator;
import de.mlauinger.pokerhands.logic.CardValueComparator;

import java.util.*;

public class Hand {

    private List<Card> cards;
    private List<ValueCount> valueCounts = new ArrayList<>(3);
    private List<SuitCount> suitCounts = new ArrayList<>(4);

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<SuitCount> getSuitCounts() {
        return suitCounts;
    }

    public List<ValueCount> getValueCounts() {
        return valueCounts;
    }

    int getCount(CardSuit suit) {
        for (SuitCount count : suitCounts) {
            if (count.getValue().equals(suit)) {
                return count.getCount();
            }
        }
        return 0;
    }

    int getCount(CardValue value) {
        for (ValueCount count : valueCounts) {
            if (count.getValue().equals(value)) {
                return count.getCount();
            }
        }
        return 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        incrementCounts(card);
    }

    private void incrementCounts(Card card) {
        for (ValueCount count : valueCounts) {
            if (count.getValue().equals(card.getCardValue())) {
                count.increment();
                break;
            }
        }
        valueCounts.add(new ValueCount(card.getCardValue(), 1));

        for (SuitCount count : suitCounts) {
            if (count.getValue().equals(card.getCardSuit())) {
                count.increment();
                break;
            }
        }
        suitCounts.add(new SuitCount(card.getCardSuit(), 1));
    }

    public void addCards(List<Card> cards) {
        cards.forEach(this::addCard);
        suitCounts.sort(new CardSuitComparator());
        valueCounts.sort(new CardValueComparator());
    }
}
