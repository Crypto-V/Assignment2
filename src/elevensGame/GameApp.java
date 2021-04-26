package elevensGame;

import java.util.Arrays;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Deck Cards = new Deck();
        System.out.println("Cards were generated and shuffled!");
        Cards.generateCards();
        CardStack<Card> deck = Cards.getDeck();
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
    }



}




