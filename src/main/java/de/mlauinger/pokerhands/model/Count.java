package de.mlauinger.pokerhands.model;

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
