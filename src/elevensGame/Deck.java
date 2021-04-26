package elevensGame;

import java.util.Random;

public class Deck {

    /*
     * This class will be responsible for creating the deck of 52 unique cards,
     * we should be able to add new cards remove new cards, clear the deck, and be able to display all cards
     * using to array method.
     */

    private CardStack<Card> deck;
    private CardStack<Card> playerhand;
    public int numberOfcards = 0;
    final String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    final Integer[] cardrating = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    final String[] suitarray = {"H", "D", "S", "C"};

    public Deck() {
        deck = new CardStack<>(52);
        playerhand = new CardStack<>(9);

    }

    //This method will generate the 52 cards and will add it into our Card list.
    public void generateCards() {
        /*
        * This method will generate the unique number of cards(52)
        * that will be inserted into our cardstack variable deck.
        * When called it will shuffle the cards directly to avoid calling the method repeatably.
        */
        for (String suite : suitarray) {
            for (int i = 0; i < rankarray.length; i++) {
                deck.addNewEntry(new Card(rankarray[i], suite, cardrating[i]));
                numberOfcards++;
            }
        }
        deck.shuffle();

    }

    private CardStack<Card> playerHand() {
        /*
        * This method will get the first 9 elements of the shuffled deck.
        * And it will populate our player hand with the removed cards.
        *@returns - playerhand of a type CardStack<Cards>
        */

        for (int i = 0; i < 9; i++) {
            playerhand.addNewEntry(deck.remove());
        }
        return playerhand;
    }

    public void printTable() {
        /*This method will be responsable for printing the example table
        * plus our playerhand cards faced up.
        */
        System.out.println("Follow the example table index to remove elements!");
        System.out.println("1|2|3|\n4|5|6|\n7|8|9|\n");

        //As soon as the index will be 2 or 5 the cursor will move to the new line
        // which will make our table to look like a matrice of 3x3.

        System.out.println("Actual Table!");
        String str = "";
        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            str += playerhand.getElementById(i).getCardRank() + playerhand.getElementById(i).getCardSuit() + "|";
            if (i == 2) str += "\n ";
            else if (i == 5) str += "\n ";
        }
        //Finally it will print the actual matrice.
        System.out.println(str);

    }

    public void remove2(int x, int y) {

        Card first = playerhand.removeElementAt(x - 1);
        System.out.println(first.toString() + " was removed!");
        Card second = playerhand.removeElementAt(y - 1);
        System.out.println(second.toString() + " was removed!");
        System.out.println(deck.getCurrentSize());

    }

    public void removeJQK(int x, int y, int z) {
        if (checkJQK(playerhand)) {
            Card first = playerhand.removeElementAt(x - 1);
            System.out.println(first.toString() + " was removed!");
            Card second = playerhand.removeElementAt(y - 1);
            System.out.println(second.toString() + " was removed!");
            Card third = playerhand.removeElementAt(z - 1);
            System.out.println(third.toString() + " was removed!");
            System.out.println(deck.getCurrentSize());
        }else System.out.println("No JQK combo founded!");
    }

    public void fillUpPlayersHand() {
        int preSize = 9 - playerhand.getCurrentSize();

        for (int i = 0; i < preSize; i++) {
            Card x = deck.remove();
            playerhand.addNewEntry(x);
            System.out.println(x.toString() + " Added to the player hand!");

        }

    }



    //TO DO
    public void giveHint() {
        //check for JQK
        //Check 11
    }

    //TO Do
    public boolean checkJQK(CardStack<Card> faceUp) {
        int count = 0;
        for (int i = 0; i < faceUp.getCurrentSize(); i++) {
            if (playerhand.getElementById(i).getCardRank().equals("K")) count++;
            else if (playerhand.getElementById(i).getCardRank().equals("Q")) count++;
            else if (playerhand.getElementById(i).getCardRank().equals("J")) count++;
            else continue;
        }
        return count >= 3;

    }

    //Check for 11 TO DO
    public void check11() {
        int index = 0;
        int firstElement = playerhand.removeElementAt(index).getCardRate();
        // it will check if any of the combo of the number will make in sum 11.
    }

    //TO DO
    public void checkLost() {
        //we have to check if not check11() AND not checkJQK() than return true game won.
    }

    //To DO
    public boolean checkWin() {
        return deck.getCurrentSize() == 0;
    }


    public CardStack<Card> getDeck() {
        return deck;
    }

    public CardStack<Card> getPlayerhand() {
        return playerHand();
    }


}