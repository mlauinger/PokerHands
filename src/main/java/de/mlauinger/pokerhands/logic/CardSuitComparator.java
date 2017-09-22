package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.SuitCount;

import java.util.Comparator;

public class CardSuitComparator implements Comparator<SuitCount>{
    @Override
    public int compare(SuitCount o1, SuitCount o2) {
        return o1.getCount() > o2.getCount() ? -1 : 1;
    }
}
