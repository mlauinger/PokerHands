package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.exceptions.NotAPokerHandException;
import de.mlauinger.pokerhands.model.hand.Hand;
import de.mlauinger.pokerhands.model.hand.HandRating;
import de.mlauinger.pokerhands.model.hand.ValueCount;

public class HandRater {

    public static void determineRating(Hand hand) throws NotAPokerHandException {
        CardValue highestCard = hand.getValueCounts().get(0).getValue();

        if (hasAtLeastOnePair(hand)) {
            if (containsThreeOfAKind(hand)) {
                if (containsFourOfAKind(hand)) {
                    hand.setRating(new HandRating("Four of a kind", 7, highestCard));
                } else {
                    if (containsFullHouse(hand)) {
                        hand.setRating(new HandRating("Full House", 6, highestCard));
                    } else {
                        hand.setRating(new HandRating("Three of a kind", 3, highestCard));
                    }
                }
            } else {
                if (containsTwoPairs(hand)) {
                    hand.setRating(new HandRating("Two Pairs", 2, highestCard));
                } else {
                    hand.setRating(new HandRating("Pair", 1, highestCard));
                }
            }
        } else {
            if (containsFlash(hand)) {
                if (isStraight(hand)) {
                    hand.setRating(new HandRating("Straight Flush", 8, highestCard));
                } else {
                    hand.setRating(new HandRating("Flush", 5, highestCard));
                }
            } else {
                if (isStraight(hand)) {
                    hand.setRating(new HandRating("Straight", 4, highestCard));
                } else {
                    hand.setRating(new HandRating("High Card", 0, highestCard));
                }
            }
        }
    }

    private static boolean hasAtLeastOnePair(Hand hand) {
        return 2 <= hand.getValueCounts().get(0).getCount();
    }

    private static boolean containsFlash(Hand hand) {
        return 5 == hand.getSuitCounts().get(0).getCount();
    }

    private static boolean isStraight(Hand hand) {
        for (int i = hand.getValueCounts().size() - 1; i > 1; i--) {
            ValueCount value = hand.getValueCounts().get(i);
            ValueCount nextValue = hand.getValueCounts().get(i - 1);
            if (null != nextValue) {
                if (!(value.getValue().ordinal() + 1 == nextValue.getValue().ordinal())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean containsThreeOfAKind(Hand hand) {
        return 3 <= hand.getValueCounts().get(0).getCount();
    }

    private static boolean containsFourOfAKind(Hand hand) {
        return 4 == hand.getValueCounts().get(0).getCount();
    }

    private static boolean containsTwoPairs(Hand hand) {
        return 2 == hand.getValueCounts().get(0).getCount() && 2 == hand.getValueCounts().get(1).getCount();
    }

    private static boolean containsFullHouse(Hand hand) {
        return 3 == hand.getValueCounts().get(0).getCount() && 2 == hand.getValueCounts().get(1).getCount();
    }

}
