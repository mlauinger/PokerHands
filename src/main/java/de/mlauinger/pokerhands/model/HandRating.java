package de.mlauinger.pokerhands.model;

public class HandRating {

    private String handName;
    private int rank;
    private CardValue highestCard;

    public HandRating(String name, int rank, CardValue highestCard) {
        this.handName = name;
        this.rank = rank;
        this.highestCard = highestCard;
    }

    public String getHandName() {
        return handName;
    }

    public int getRank() {
        return rank;
    }

    public CardValue getHighestCard() {
        return highestCard;
    }
}
