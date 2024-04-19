
package com.example.memorycardgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

public class MemoryGameController implements Initializable {

    @FXML
    private Label correctGuessesLabel;

    @FXML
    private Label guessLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList<MemoryCard> cardsInGame;

    private MemoryCard firstCard, secondCard;

    private int numOfGuess;

    private int numOfMatches;

    @FXML
    void playAgain() {
        firstCard = null;
        secondCard = null;
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for (int i = 0; i < imagesFlowPane.getChildren().size() / 2; i++) {
            Card cardDealt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
            // duplicate same cardDealt to get 10 cards, 5 unique
        }
        Collections.shuffle(cardsInGame);
        flipAllCards();
        resetLabels();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeImageView();
        playAgain();
    }

    /**
     * This wil add a number to each ImageView and set the image to the back of the card
     */

    private void initializeImageView() {
        for (int i = 0; i < imagesFlowPane.getChildren().size(); i++) {
            // cast the Node to be of type ImageView
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);

            //register a click listener
            imageView.setOnMouseClicked(event -> {
                flipCard((int)imageView.getUserData()) ;
            });
        }
    }

    /**
     * This will show the BACK of all cards not matched
     */

    private void flipAllCards() {
        for (int i = 0; i < cardsInGame.size(); i++) {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if (card.isMatched()) {
                imageView.setImage(card.getImage());
            }
            else {
                imageView.setImage(card.getBackOfCardImage());
            }
        }
    }

    private void flipCard(int indexOfCard) {
        if (firstCard == null && secondCard == null) {
            flipAllCards();
        }
        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);
        MemoryCard card = cardsInGame.get(indexOfCard);

        if (firstCard == null && (!card.isMatched())) {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        }
        else if (secondCard == null && (!card.isMatched()) && card != firstCard) {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels() {
        correctGuessesLabel.setText(Integer.toString(numOfMatches));
        guessLabel.setText(Integer.toString(numOfGuess));
    }

    private void resetLabels() {
        correctGuessesLabel.setText(Integer.toString(0));
        guessLabel.setText(Integer.toString(0));
    }

    private void checkForMatch() {
        if (firstCard.isSameCard(secondCard)) {
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        // both become null; we reset for another guess
        firstCard = null;
        secondCard = null;
    }

}
