package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.exceptions.NotAPokerHandException;
import de.mlauinger.pokerhands.model.hand.Hand;
import de.mlauinger.pokerhands.model.hand.HandRating;
import de.mlauinger.pokerhands.model.hand.ValueCount;

public class HandRater {

    public static HandRating determineRating(Hand hand) throws NotAPokerHandException {
        CardValue highestCard = hand.getValueCounts().get(0).getValue();

        if (2 <= hand.getValueCounts().get(0).getCount()) {
            if (3 <= hand.getValueCounts().get(0).getCount()) {
                if (4 == hand.getValueCounts().get(0).getCount()) {
                    return new HandRating("Four of a kind", 7, highestCard);
                } else {
                    if (2 == hand.getValueCounts().get(1).getCount()) {
                        return new HandRating("Full House", 6, highestCard);
                    } else {
                        return new HandRating("Three of a kind", 3, highestCard);
                    }
                }
            } else {
                if (2 == hand.getValueCounts().get(1).getCount()) {
                    return new HandRating("Two Pairs", 2, highestCard);
                } else {
                    return new HandRating("Pair", 1, highestCard);
                }
            }
        } else {
            if (5 == hand.getSuitCounts().get(0).getCount()) {
                if (isStraight(hand)) {
                    return new HandRating("Straight Flush", 8, highestCard);
                } else {
                    return new HandRating("Flush", 5, highestCard);
                }
            } else {
                if (isStraight(hand)) {
                    return new HandRating("Straight", 4, highestCard);
                } else {
                    return new HandRating("High Card", 0, highestCard);
                }
            }
        }
    }

    private static boolean isStraight(Hand hand) {
        for (int i = hand.getValueCounts().size() - 1; i > 1; i--) {
            ValueCount value = hand.getValueCounts().get(i);
            ValueCount nextValue = hand.getValueCounts().get(i -1);
            if (null != nextValue) {
                if (!(value.getValue().ordinal() + 1 == nextValue.getValue().ordinal())) {
                    return false;
                }
            }
        }
        return true;
    }

}
