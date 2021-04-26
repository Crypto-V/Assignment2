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
        System.out.println("|0|1|2|\n|3|4|5|\n|6|7|8|\n");

        //As soon as the index will be 2 or 5 the cursor will move to the new line
        // which will make our table to look like a matrice of 3x3.

        System.out.println("Actual Table!");
        String str = "|";
        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            str += playerhand.getElementById(i).getCardRank() + playerhand.getElementById(i).getCardSuit() + "|";
            if (i == 2) str += "\n|";
            else if (i == 5) str += "\n|";
        }
        //Finally it will print the actual matrice.
        System.out.println(str);

    }

    public void remove2(int x, int y) {
        //This method will remove 2 cards from the player hand if in sum will make 11,
        //which automatically is filtering the J Q K cards since the value of each card is above 11.
        int xValue = playerhand.getElementById(x - 1).getCardRate();
        int yValue = playerhand.getElementById(y - 1).getCardRate();
        int sum = xValue + yValue;

        //If the cards the were passed will make in sum 11 program
        // will continue to removing the cards from the deck.
        //else it will display that numbers don't make 11 in sum.
        if (sum == 11) {
            Card first = playerhand.removeElementAt(x - 1);
            System.out.println(first.toString() + " was removed!");
            fillUpPlayersHand();
            Card second = playerhand.removeElementAt(y - 1);
            System.out.println(second.toString() + " was removed!");
            fillUpPlayersHand();
            System.out.println("Cards in deck: " + deck.getCurrentSize());
        } else {
            System.out.println("Numbers you entered doesn't make 11 in sum! ");
        }

    }

    public void removeJQK(int x, int y, int z) {

        if (checkJQK(playerhand)) {
            Card first = playerhand.removeElementAt(x - 1);
            System.out.println(first.toString() + " was removed!");
            fillUpPlayersHand();
            Card second = playerhand.removeElementAt(y - 1);
            System.out.println(second.toString() + " was removed!");
            fillUpPlayersHand();
            Card third = playerhand.removeElementAt(z - 1);
            System.out.println(third.toString() + " was removed!");
            fillUpPlayersHand();
            System.out.println(deck.getCurrentSize());
        } else System.out.println("No JQK combo founded!");
    }

    public void fillUpPlayersHand() {
        int preSize = 9 - playerhand.getCurrentSize();

        for (int i = 0; i < preSize; i++) {
            Card x = deck.remove();
            playerhand.addNewEntry(x);
            System.out.println(x.toString() + "< + > Added to the player hand!\n");
        }
    }

    public void giveHint() {
        System.out.println("___________________________________");
        System.out.println("|The list of possible combinations!|");
        System.out.println("|__________________________________|");
        check11();
        checkJQK(playerhand);
        System.out.println("####################################");

    }

    public boolean checkJQK(CardStack<Card> faceUp) {
        int kCount = 0;
        int kIndex = 0;
        int qCount = 0;
        int qIndex = 0;
        int jCount = 0;
        int jIndex = 0;

        for (int i = 0; i < faceUp.getCurrentSize(); i++) {
            switch (playerhand.getElementById(i).getCardRank()) {
                case "K":
                    kIndex = i;
                    kCount++;
                    break;
                case "Q":
                    qIndex = i;
                    qCount++;
                    break;
                case "J":
                    jIndex = i;
                    jCount++;
                    break;
            }

            if (kCount > 0 && qCount > 0 && jCount > 0) {
                System.out.println("Card" + playerhand.getElementById(kIndex).toString() + " at index " + kIndex);
                System.out.println("Card" + playerhand.getElementById(qIndex).toString() + " at index " + qIndex);
                System.out.println("Card" + playerhand.getElementById(jIndex).toString() + " at index " + jIndex);
                System.out.println();
                return true;
            }

        }
        return false;

    }

    public boolean check11() {
        boolean flag = false;
        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            for (int j = 0; j < playerhand.getCurrentSize(); j++) {
                int sum = playerhand.getElementById(i).getCardRate() + playerhand.getElementById(j).getCardRate();
                if (sum == 11) {
                    System.out.println("Card" + playerhand.getElementById(i).toString() + " at index " + i);
                    System.out.println("Card" + playerhand.getElementById(j).toString() + " at index " + j);
                    System.out.println("Can be removed!!");
                    flag = true;
                } else flag = false;
            }

        }
        return flag;
    }

    public boolean checkLost() {

        if(!check11() && !checkJQK(playerhand)){
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        return deck.getCurrentSize() == 0;
    }

    public CardStack<Card> getDeck() {
        return deck;
    }

    public CardStack<Card> getPlayerhand() {
        //return the playerhand ADT values.
        return playerHand();
    }


}