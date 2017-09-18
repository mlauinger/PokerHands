package de.mlauinger.pokerhands.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HandTest {


    @Test
    public void testInitializeHand() {
        Hand hand = new Hand();
        for (CardValue cardValue : CardValue.values()) {
            assert 0 == hand.getCount(cardValue);
        }
        for (CardSuit suit : CardSuit.values()) {
            assert 0 == hand.getCount(suit);
        }
    }

    @Test
    public void testAddCardToHand() throws InvalidInputException {
        Hand hand = new Hand();
        Card heartKing = new Card("H", "K");
        hand.addCard(heartKing);
        assert 1 == hand.getCount(heartKing.getCardSuit());
        assert 0 == hand.getCount(CardSuit.CLUB);
        assert 1 == hand.getCount(heartKing.getCardValue());
        assert 0 == hand.getCount(CardValue.ACE);
    }

    @Test
    public void testAddMultipleCardsToHand() throws InvalidInputException {
        Hand hand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "K"),
                new Card("S", "K"),
                new Card("D", "7"),
                new Card("D", "A"),
                new Card("C", "K")
        );
        hand.addCards(cards);
        assert 2 == hand.getCount(CardSuit.DIAMOND);
        assert 1 == hand.getCount(CardSuit.HEART);
        assert 1 == hand.getCount(CardSuit.SPADE);
        assert 1 == hand.getCount(CardSuit.CLUB);
        assert 3 == hand.getCount(CardValue.KING);
        assert 1 == hand.getCount(CardValue.SEVEN);
        assert 1 == hand.getCount(CardValue.ACE);
        assert 0 == hand.getCount(CardValue.SIX);
    }

}
