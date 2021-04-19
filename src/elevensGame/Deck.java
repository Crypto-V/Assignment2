package elevensGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    /*This class will be responsible for creating the deck of 52 unique cards,
    * we should be able to add new cards remove new cards, clear the deck, and be able to display all cards
    * using to array method. */
    private Card[] Deck = new Card[52];

    public Deck(){
        String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Integer[] cardrating = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suitarray = {"H", "D", "S", "C"};

        for (String suitElement:suitarray) {

        }
    }


    public Card[] toArray() {
        return Deck;
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        Card[] deckList = myDeck.toArray();

        System.out.println(Arrays.toString(deckList));
    }
}
