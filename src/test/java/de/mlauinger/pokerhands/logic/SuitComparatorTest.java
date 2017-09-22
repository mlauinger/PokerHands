package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.CardSuit;
import de.mlauinger.pokerhands.model.SuitCount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SuitComparatorTest {

    @Test
    public void testSortCardsWithDifferentAndDuplicatValues() {
        List<SuitCount> suitCounts = new ArrayList<>();
        suitCounts.add(new SuitCount(CardSuit.HEART, 2));
        suitCounts.add(new SuitCount(CardSuit.DIAMOND, 0));
        suitCounts.add(new SuitCount(CardSuit.SPADE, 1));
        suitCounts.add(new SuitCount(CardSuit.CLUB, 2));

        suitCounts.sort(new CardSuitComparator());

        assert CardSuit.HEART.equals(suitCounts.get(0).getValue());
        assert CardSuit.CLUB.equals(suitCounts.get(1).getValue());
        assert CardSuit.SPADE.equals(suitCounts.get(2).getValue());
        assert CardSuit.DIAMOND.equals(suitCounts.get(3).getValue());
    }

    @Test
    public void testSortCardsWithDifferent() {
        List<SuitCount> suitCounts = new ArrayList<>();
        suitCounts.add(new SuitCount(CardSuit.HEART, 2));
        suitCounts.add(new SuitCount(CardSuit.DIAMOND, 1));
        suitCounts.add(new SuitCount(CardSuit.SPADE, 3));
        suitCounts.add(new SuitCount(CardSuit.CLUB, 0));

        suitCounts.sort(new CardSuitComparator());

        assert CardSuit.SPADE.equals(suitCounts.get(0).getValue());
        assert CardSuit.HEART.equals(suitCounts.get(1).getValue());
        assert CardSuit.DIAMOND.equals(suitCounts.get(2).getValue());
        assert CardSuit.CLUB.equals(suitCounts.get(3).getValue());
    }

    @Test
    public void testSortCardsSortedInverted() {
        List<SuitCount> suitCounts = new ArrayList<>();
        suitCounts.add(new SuitCount(CardSuit.HEART, 0));
        suitCounts.add(new SuitCount(CardSuit.DIAMOND, 1));
        suitCounts.add(new SuitCount(CardSuit.SPADE, 2));
        suitCounts.add(new SuitCount(CardSuit.CLUB, 3));

        suitCounts.sort(new CardSuitComparator());

        assert CardSuit.CLUB.equals(suitCounts.get(0).getValue());
        assert CardSuit.SPADE.equals(suitCounts.get(1).getValue());
        assert CardSuit.DIAMOND.equals(suitCounts.get(2).getValue());
        assert CardSuit.HEART.equals(suitCounts.get(3).getValue());
    }

    @Test
    public void testSortCardsAllWithSameValue() {
        List<SuitCount> suitCounts = new ArrayList<>();
        suitCounts.add(new SuitCount(CardSuit.HEART, 2));
        suitCounts.add(new SuitCount(CardSuit.DIAMOND, 2));
        suitCounts.add(new SuitCount(CardSuit.SPADE, 2));
        suitCounts.add(new SuitCount(CardSuit.CLUB, 2));

        suitCounts.sort(new CardSuitComparator());

        assert CardSuit.HEART.equals(suitCounts.get(0).getValue());
        assert CardSuit.DIAMOND.equals(suitCounts.get(1).getValue());
        assert CardSuit.SPADE.equals(suitCounts.get(2).getValue());
        assert CardSuit.CLUB.equals(suitCounts.get(3).getValue());
    }

}
