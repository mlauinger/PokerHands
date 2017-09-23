package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.hand.Hand;

import java.util.Comparator;

public class HandComparator implements Comparator<Hand>{

    @Override
    public int compare(Hand o1, Hand o2) {
        if(o1.getRating().getRank() == o2.getRating().getRank()) {
            if(o1.getRating().getHighestCard() == o2.getRating().getHighestCard()) {
                return 0;
            }
            if(o1.getRating().getHighestCard().ordinal() > o2.getRating().getHighestCard().ordinal()) {
                return 1;
            }
            return -1;
        }
        if(o1.getRating().getRank() > o2.getRating().getRank()) {
            return 1;
        }
        return -1;
    }
}
