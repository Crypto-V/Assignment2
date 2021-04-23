package elevensGame;

import somePackageWithArrays.CardStack;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Deck {

    /*
     * This class will be responsible for creating the deck of 52 unique cards,
     * we should be able to add new cards remove new cards, clear the deck, and be able to display all cards
     * using to array method.
     */

    private CardStack<Card> deck;
    public int numberOfcards = 0;
    final String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    final Integer[] cardrating = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    final String[] suitarray = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public Deck() {
        deck = new CardStack<>(52);
    }

    public CardStack<Card> getDeck() {
        return deck;
    }

    //This method will generate the 52 cards and will add it into our Card list.
    public void generateCards() {
        for (String suite : suitarray) {
            for (int i = 0; i < rankarray.length; i++) {
                deck.addNewEntry(new Card(rankarray[i], suite, cardrating[i]));
                numberOfcards++;

            }
        }
    }

//    public Card[] pick9(CardStack<Card> tempList){
//
//    }

}