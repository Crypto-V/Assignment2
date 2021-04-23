package elevensGame;

import CardGame.BagSet;
import CardGame.Card;
import CardGame.Deck;
import somePackageWithArrays.CardStack;

import java.util.Arrays;

public class GameApp {
    public static void main(String[] args) {
        elevensGame.Deck carddeck = new elevensGame.Deck();
        System.out.println("Welcome to the game ");
        carddeck.generateCards();
        CardStack<elevensGame.Card> cs = carddeck.getDeck();
        System.out.println(Arrays.toString(cs.toArray()));

        //remove nine cards from the deck. Pass them to the player

        BagSet<elevensGame.Card> playerhand = new BagSet(9);
        for (int i = 0; i < 9; i++)
        {
            playerhand.addNewEntry(cs.remove());
        }
        System.out.println(Arrays.toString(playerhand.toArray()));
        System.out.println(Arrays.toString(cs.toArray()));













//        //Create the fuckin deck.
//        Deck deck1 = new Deck();
//        deck1.generateCards();
//        // Create a variable of cardstack type and asign our list using getdeck.
//        CardStack<Card> cs = deck1.getDeck();
//        System.out.println(Arrays.toString(cs.toArray()));
//        System.out.println(cs.isEmpty());
//        cs.shuffle();
//        System.out.println(Arrays.toString(cs.toArray()));


    }


}
