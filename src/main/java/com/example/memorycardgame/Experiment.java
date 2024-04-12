package com.example.memorycardgame;

public class Experiment {

    public static void main(String[] args) {
        Card aceOfSpades = new Card("spades", "ace");
        Card kingOfHearts = new Card("hearts", "king");
        Card twoOfDiamonds = new Card("diamonds", "2");
        System.out.println(aceOfSpades);
        System.out.println(kingOfHearts);

        System.out.printf("%s value: %d %n", aceOfSpades, aceOfSpades.getValue());
        System.out.printf("%s value: %d %n", kingOfHearts, kingOfHearts.getValue());
        System.out.printf("%s value: %d %n", twoOfDiamonds, twoOfDiamonds.getValue());

        System.out.println("\n ~~~~ Building a Card Deck ~~~~ ");
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        for (int i=0; i<=5; i++) {
            System.out.println(deck.dealTopCard());
        }

        System.out.println(deck);
    }
}