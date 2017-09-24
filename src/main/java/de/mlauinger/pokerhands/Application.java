package de.mlauinger.pokerhands;

import de.mlauinger.pokerhands.logic.HandComparator;
import de.mlauinger.pokerhands.model.card.Card;
import de.mlauinger.pokerhands.model.exceptions.InvalidInputException;
import de.mlauinger.pokerhands.model.hand.Hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws InvalidInputException {
        Application app = new Application();
        System.out.println("Welcome to the Poker Hand Compare.");
        System.out.println("");
        System.out.println("Please enter a poker hand consisting of five cards in the following format: <Suit><Value> <Suit><Value> (e.g. H5 HA DK C9 D6)");

        List<Hand> inputHands = new ArrayList<>();


        for (int i = 0; i < app.getHandsToCompare(); i++) {
            String input = app.readInput();
            Hand hand = new Hand();
            hand.addCards(app.parseInput(input.toUpperCase()));
            inputHands.add(hand);
            if (i < app.getHandsToCompare()) {
                System.out.println("You may now enter another hand");
            }
        }
        inputHands.sort(new HandComparator());
        System.out.println("The highest Hand is: " + inputHands.get(inputHands.size() - 1).getRating().getHandName());

    }

    private String readInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                if (input.length() < 14) {
                    throw new IOException("Input to short");
                }
                return input;
            } catch (IOException e) {
                System.err.println("Whoops! Looks like something went wrong with your input. Please try again!");
                return readInput();
        }
    }

    private List<Card> parseInput(String input) throws InvalidInputException {
        List<Card> cards = new ArrayList<>();
        String parts[] = input.split(" ");
        for (String part : parts) {
            cards.add(new Card(part.trim().substring(0, 1), part.trim().substring(1)));
        }
        return cards;
    }

    private int getHandsToCompare() {
        return 2;
    }
}
