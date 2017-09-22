package de.mlauinger.pokerhands.model;

import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.card.CardSuit;
import de.mlauinger.pokerhands.model.card.CardValue;
import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCreateCardWithValidParameters() throws InvalidInputException {
        Card card = new Card("H", "6");
        assert CardSuit.HEART.equals(card.getCardSuit());
        assert CardValue.SIX.equals(card.getCardValue());
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCardWithInvalidSuit() throws InvalidInputException {
        Card card = new Card("A", "6");
        assert CardValue.SIX.equals(card.getCardValue());
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCardWithInvalidValue() throws InvalidInputException {
        Card card = new Card("H", "11");
        assert CardSuit.HEART.equals(card.getCardSuit());
    }

}
