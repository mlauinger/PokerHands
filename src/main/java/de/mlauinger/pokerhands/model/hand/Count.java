package de.mlauinger.pokerhands.model.hand;

public class Count {

    private int count;

    public Count(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
