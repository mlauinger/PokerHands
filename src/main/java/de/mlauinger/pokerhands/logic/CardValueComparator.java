package de.mlauinger.pokerhands.logic;

import de.mlauinger.pokerhands.model.hand.ValueCount;

import java.util.Comparator;

public class CardValueComparator implements Comparator<ValueCount> {

    @Override
    public int compare(ValueCount count1, ValueCount count2) {
        if(count1.getCount() > count2.getCount()) {
            return -1;
        }
        if(count1.getCount() == count2.getCount() && count1.getValue().ordinal() > count2.getValue().ordinal()) {
            return -1;
        }
        return 1;
    }
}
