package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;
import de.mlauinger.pokerhands.model.hand.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class HandComparatorTest {

    private Hand pair = new Hand();
    private Hand secondPair = new Hand();
    private Hand street = new Hand();
    private Hand fourAces = new Hand();
    private Hand straightFlush = new Hand();
    private Hand heartFlush = new Hand();
    private Hand diamondFlush = new Hand();


    private HandComparator comp = new HandComparator();

    private static final int HIGHER = 1;
    private static final int LOWER = -1;
    private static final int SAME = 0;

    @Before
    public void setup() throws InvalidInputException {

        Card heartAce = new Card("H", "A");
        Card spadeAce  = new Card("S", "A");
        Card clubAce  = new Card("C", "A");
        Card diamondAce = new Card("D", "A");
        Card heartKing = new Card("H", "K");
        Card heartQueen = new Card("H", "Q");
        Card heartJack = new Card("H", "J");
        Card diamondQueen = new Card("D", "Q");
        Card diamondJack = new Card("D", "J");
        Card heartTen = new Card("H", "10");
        Card heartNine = new Card("H", "9");
        Card diamondNine = new Card("D", "9");
        Card diamondTen = new Card("D", "10");
        Card spadeTen = new Card("S", "10");
        Card diamondTwo = new Card("D", "2");


        pair.addCards(Arrays.asList(heartAce, heartJack, heartTen, spadeAce, diamondTwo));
        street.addCards(Arrays.asList(heartAce, heartJack, heartKing, spadeTen, heartQueen));
        fourAces.addCards(Arrays.asList(heartAce, spadeAce, clubAce, diamondAce, heartKing));
        straightFlush.addCards(Arrays.asList(heartAce, heartJack, heartKing, heartQueen, heartTen));
        heartFlush.addCards(Arrays.asList(heartAce, heartJack, heartNine, heartQueen, heartTen));
        diamondFlush.addCards(Arrays.asList(diamondAce, diamondJack, diamondQueen, diamondNine, diamondTen ));
        secondPair.addCards(Arrays.asList(diamondAce, heartKing, diamondTwo, diamondQueen, clubAce));
    }

    @Test
    public void testStraightShouldBeHigherThanPair() {
        Assert.assertEquals(HIGHER, comp.compare(street, pair));
        Assert.assertEquals(LOWER, comp.compare(pair, street));
    }

    @Test
    public void testStraightFlushShouldBeHigherThanFourAces() {
        Assert.assertEquals(HIGHER, comp.compare(straightFlush, fourAces));
        Assert.assertEquals(LOWER, comp.compare(fourAces, straightFlush));
    }

    @Test
    public void testTwoFlushWithSameRangeAreEqual() {
        Assert.assertEquals(SAME, comp.compare(heartFlush, diamondFlush));
        Assert.assertEquals(SAME, comp.compare(diamondFlush, heartFlush));
    }

    @Test
    public void testTwoPairsWithEqualValueShouldBeRatedByHighestCard() {
        Assert.assertEquals(HIGHER, comp.compare(secondPair, pair));
        Assert.assertEquals(LOWER, comp.compare(pair, secondPair));
    }

    @Test
    public void testSameHighestCardShouldBeRatedBySecondHighest() {

    }

}
