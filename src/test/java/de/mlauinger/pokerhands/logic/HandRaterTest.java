package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;
import de.mlauinger.pokerhands.model.hand.Hand;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HandRaterTest {

    @Test
    public void testDetermineRankIsHighCard() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "5"),
                new Card("D", "7"),
                new Card("D", "A"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 0 == hand.getRating().getRank();
        assert CardValue.ACE == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsPair() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "5"),
                new Card("D", "7"),
                new Card("D", "K"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 1 == hand.getRating().getRank();
        assert CardValue.KING == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsTwoPairs() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "2"),
                new Card("D", "K"),
                new Card("D", "A"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 2 == hand.getRating().getRank();
        assert CardValue.KING == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsThreeOfAKind() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "2"),
                new Card("D", "7"),
                new Card("D", "2"),
                new Card("C", "2")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 3 == hand.getRating().getRank();
        assert CardValue.TWO == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsStraight() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "J"),
                new Card("D", "Q"),
                new Card("D", "9"),
                new Card("C", "10")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 4 == hand.getRating().getRank();
        assert CardValue.KING == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsFlush() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("D", "K"),
                new Card("D", "5"),
                new Card("D", "7"),
                new Card("D", "A"),
                new Card("D", "2")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 5 == hand.getRating().getRank();
        assert CardValue.ACE == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsFullHouse() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "K"),
                new Card("D", "K"),
                new Card("D", "10"),
                new Card("C", "10")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 6 == hand.getRating().getRank();
        assert CardValue.KING == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsFourOfAKind() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "J"),
                new Card("S", "J"),
                new Card("D", "J"),
                new Card("D", "9"),
                new Card("C", "J")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 7 == hand.getRating().getRank();
        assert CardValue.JACK == hand.getRating().getHighestCard();
    }

    @Test
    public void testDetermineRankIsStraightFlush() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("D", "K"),
                new Card("D", "J"),
                new Card("D", "Q"),
                new Card("D", "9"),
                new Card("D", "10")
        );
        hand.addCards(cards);
        HandRater.determineRating(hand);
        assert 8 == hand.getRating().getRank();
        assert CardValue.KING == hand.getRating().getHighestCard();
    }

}
