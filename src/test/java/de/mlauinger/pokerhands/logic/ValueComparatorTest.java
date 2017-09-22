package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.hand.ValueCount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValueComparatorTest {

    @Test
    public void testSortValuesWithSameCountByValue() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.SEVEN, 2));
        valueCounts.add(new ValueCount(CardValue.NINE, 2));
        valueCounts.add(new ValueCount(CardValue.THREE, 2));
        valueCounts.add(new ValueCount(CardValue.TWO, 2));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.NINE.equals(valueCounts.get(0).getValue());
        assert CardValue.SEVEN.equals(valueCounts.get(1).getValue());
        assert CardValue.THREE.equals(valueCounts.get(2).getValue());
        assert CardValue.TWO.equals(valueCounts.get(3).getValue());
    }

    @Test
    public void testAceIsHighestCard() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.SEVEN, 1));
        valueCounts.add(new ValueCount(CardValue.KING, 1));
        valueCounts.add(new ValueCount(CardValue.THREE, 1));
        valueCounts.add(new ValueCount(CardValue.ACE, 1));
        valueCounts.add(new ValueCount(CardValue.TWO, 1));
        valueCounts.add(new ValueCount(CardValue.JOKER, 1));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.ACE.equals(valueCounts.get(0).getValue());
        assert CardValue.KING.equals(valueCounts.get(1).getValue());
        assert CardValue.JOKER.equals(valueCounts.get(2).getValue());
        assert CardValue.SEVEN.equals(valueCounts.get(3).getValue());
        assert CardValue.THREE.equals(valueCounts.get(4).getValue());
        assert CardValue.TWO.equals(valueCounts.get(5).getValue());
    }

    @Test
    public void testTwoKingsAreHigherThanOneAce() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.ACE, 1));
        valueCounts.add(new ValueCount(CardValue.KING, 2));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.KING.equals(valueCounts.get(0).getValue());
        assert CardValue.ACE.equals(valueCounts.get(1).getValue());
    }

    @Test
    public void testSortDifferentValuesAndCounts() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.SEVEN, 3));
        valueCounts.add(new ValueCount(CardValue.KING, 1));
        valueCounts.add(new ValueCount(CardValue.THREE, 6));
        valueCounts.add(new ValueCount(CardValue.ACE, 2));
        valueCounts.add(new ValueCount(CardValue.TWO, 4));
        valueCounts.add(new ValueCount(CardValue.JOKER, 4));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.THREE.equals(valueCounts.get(0).getValue());
        assert CardValue.JOKER.equals(valueCounts.get(1).getValue());
        assert CardValue.TWO.equals(valueCounts.get(2).getValue());
        assert CardValue.SEVEN.equals(valueCounts.get(3).getValue());
        assert CardValue.ACE.equals(valueCounts.get(4).getValue());
        assert CardValue.KING.equals(valueCounts.get(5).getValue());
    }

    @Test
    public void testSortAlreadySortedByCount() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.SEVEN, 6));
        valueCounts.add(new ValueCount(CardValue.KING, 5));
        valueCounts.add(new ValueCount(CardValue.THREE, 4));
        valueCounts.add(new ValueCount(CardValue.ACE, 3));
        valueCounts.add(new ValueCount(CardValue.TWO, 2));
        valueCounts.add(new ValueCount(CardValue.JOKER, 1));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.SEVEN.equals(valueCounts.get(0).getValue());
        assert CardValue.KING.equals(valueCounts.get(1).getValue());
        assert CardValue.THREE.equals(valueCounts.get(2).getValue());
        assert CardValue.ACE.equals(valueCounts.get(3).getValue());
        assert CardValue.TWO.equals(valueCounts.get(4).getValue());
        assert CardValue.JOKER.equals(valueCounts.get(5).getValue());
    }

    @Test
    public void testSortAlreadySortedByValue() {
        List<ValueCount> valueCounts = new ArrayList<>();
        valueCounts.add(new ValueCount(CardValue.ACE, 1));
        valueCounts.add(new ValueCount(CardValue.KING, 1));
        valueCounts.add(new ValueCount(CardValue.JOKER, 1));
        valueCounts.add(new ValueCount(CardValue.SEVEN, 1));
        valueCounts.add(new ValueCount(CardValue.THREE, 1));
        valueCounts.add(new ValueCount(CardValue.TWO, 1));

        valueCounts.sort(new CardValueComparator());

        assert CardValue.ACE.equals(valueCounts.get(0).getValue());
        assert CardValue.KING.equals(valueCounts.get(1).getValue());
        assert CardValue.JOKER.equals(valueCounts.get(2).getValue());
        assert CardValue.SEVEN.equals(valueCounts.get(3).getValue());
        assert CardValue.THREE.equals(valueCounts.get(4).getValue());
        assert CardValue.TWO.equals(valueCounts.get(5).getValue());
    }
}
