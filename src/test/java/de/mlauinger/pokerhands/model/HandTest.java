package de.mlauinger.pokerhands.model;

import org.junit.Test;

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

}
