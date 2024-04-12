package com.example.memorycardgame;
import java.util.*;

public class DeckOfCards {

    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        for (String suit : suits) {
            for (String faceName : faceNames) {
                deck.add(new Card(suit, faceName));
            }
        }

    }

    /**
     * This method will shuffle the card objects
     */

    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * This method will deal top card of the deck
     */

    public Card dealTopCard() {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method returns the number of calls left in the deck
     */

    public int getNumOfCards() {
        return deck.size();
    }

}