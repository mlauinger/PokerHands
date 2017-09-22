package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;
import de.mlauinger.pokerhands.model.exceptions.NotAPokerHandException;
import de.mlauinger.pokerhands.model.hand.Hand;
import de.mlauinger.pokerhands.model.hand.HandRating;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HandRaterTest {

    @Test
    public void testDetermineRankIsHighCard() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "5"),
                new Card("D", "7"),
                new Card("D", "A"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 0 == rating.getRank();
        assert CardValue.ACE == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsPair() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "5"),
                new Card("D", "7"),
                new Card("D", "K"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 1 == rating.getRank();
        assert CardValue.KING == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsTwoPairs() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "2"),
                new Card("D", "K"),
                new Card("D", "A"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 2 == rating.getRank();
        assert CardValue.KING == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsThreeOfAKind() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "2"),
                new Card("D", "7"),
                new Card("D", "2"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 3 == rating.getRank();
        assert CardValue.TWO == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsStraight() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "J"),
                new Card("D", "Q"),
                new Card("D", "9"),
                new Card("C", "10")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 4 == rating.getRank();
        assert CardValue.KING == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsFlush() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("D", "K"),
                new Card("D", "5"),
                new Card("D", "7"),
                new Card("D", "A"),
                new Card("D", "2")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 5 == rating.getRank();
        assert CardValue.ACE == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsFullHouse() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "K"),
                new Card("D", "K"),
                new Card("D", "10"),
                new Card("C", "10")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 6 == rating.getRank();
        assert CardValue.KING == rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsFourOfAKind() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "J"),
                new Card("S", "J"),
                new Card("D", "J"),
                new Card("D", "9"),
                new Card("C", "J")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 7 == rating.getRank();
        assert CardValue.JOKER== rating.getHighestCard();
    }

    @Test
    public void testDetermineRankIsStraightFlush() throws InvalidInputException, NotAPokerHandException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("D", "K"),
                new Card("D", "J"),
                new Card("D", "Q"),
                new Card("D", "9"),
                new Card("D", "10")
        );
        hand.addCards(cards);
        HandRating rating = HandRater.determineRating(hand);
        assert 8 == rating.getRank();
        assert CardValue.KING == rating.getHighestCard();
    }

}
