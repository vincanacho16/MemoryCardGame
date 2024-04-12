package com.example.memorycardgame;
import java.util.*;

public class Card {
    private String suit;
    private String faceName;

    public Card(String suit, String faceName) {
        setSuit(suit);
        // validation for 4 suits
        setFaceName(faceName);
        // validation for 13 face names
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("hearts", "diamonds", "clubs", "spades");
    }

    /**
     * valid suits are "hearts", "diamonds", "clubs", and "spades"
     * @param suit
     */

    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
            //Create exception if suit isn't valid
        else
            throw new IllegalArgumentException(suit + " invalid, must be one of " + getValidSuits());
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames() {
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
    }

    /**
     * valid names are "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"
     * @param faceName
     */

    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if (getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " invalid, must be one of " + getValidFaceNames());
    }

    public String toString() {
        return faceName + " of " + suit;
    }

    public String getColour() {
        if (suit.equals("hearts") || suit.equals("diamonds")) {
            return "red";
        }
        else
            return "black";
    }

    /**
     * This method will return the value of the card
     * "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"
     */

    public int getValue() {
        // think of getValidFaceNames() as a List and add 2 to index
        return getValidFaceNames().indexOf(faceName) + 2;
    }

}