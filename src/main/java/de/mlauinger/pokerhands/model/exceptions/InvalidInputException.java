package de.mlauinger.pokerhands.model.exceptions;

public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("The given card-input is not a valid Poker-Card");
    }
}
