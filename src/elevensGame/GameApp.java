package elevensGame;

import java.util.Arrays;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Deck Cards = new Deck();
        CardStack<Card> deck = Cards.getDeck();
        

        System.out.println("Cards were generated and shuffled!");
        Cards.generateCards();

        System.out.println(Arrays.toString(deck.toArray()));
        Cards.getPlayerhand();

        Scanner input = new Scanner(System.in);
        Cards.printTable();

        Cards.giveHint();
        boolean z = Cards.checkJQK(Cards.getPlayerhand());
        System.out.println(z);
        int x = 4;
        while(x < 10){
            Cards.printTable();

            System.out.println("Please enter your desired location!");
            Cards.remove2(input.nextInt(),input.nextInt());



            x++;

        }
    }



}




