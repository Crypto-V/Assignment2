package elevensGame;

import java.util.Arrays;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Deck Cards = new Deck();
        Cards.generateCards();
        CardStack<Card> deck = Cards.getDeck();
        System.out.println(Arrays.toString(deck.toArray()));
        deck.shuffle();
        System.out.println(Arrays.toString(deck.toArray()));
        Cards.getPlayerhand();

        Scanner input = new Scanner(System.in);
        int x = 4;
        while(x < 10){
            Cards.printTable();
            System.out.println("Please enter your desired location!");
            Cards.remove2(input.nextInt(),input.nextInt());
            Cards.fillUpPlayersHand();
            x++;

        }

        //Add method to the 11 when removing cards
        //Create method to remove JQK
        //Create Queue















//        System.out.println("Welcome to the game ");
//        carddeck.generateCards();
//        CardStack<Card> cs = carddeck.getDeck();
//        System.out.println(Arrays.toString(carddeck.getPlayerhand().toArray()));
//        System.out.println(Arrays.toString(cs.toArray()));









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
