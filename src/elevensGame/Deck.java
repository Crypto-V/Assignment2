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
        for (String suite : suitarray) {
            for (int i = 0; i < rankarray.length; i++) {
                deck.addNewEntry(new Card(rankarray[i], suite, cardrating[i]));
                numberOfcards++;
            }
        }
        deck.shuffle();
        System.out.println("Shuffling the deck!");
    }

    private  CardStack<Card> playerHand() {
        deck.shuffle();
        Card x;
        for (int i = 0; i < 9; i++)
        {
            playerhand.addNewEntry(deck.remove());
        }
        return playerhand;
    }

    public void printTable() {
        System.out.println("Follow the example table index to remove elements!");
        System.out.println("1|2|3|\n4|5|6|\n7|8|9|\n");

        System.out.println("Actual Table!");
        String str = "";
        for (int i = 0;i<playerhand.getCurrentSize();i++){
            str += playerhand.getElementById(i).getCardRank()+playerhand.getElementById(i).getCardSuit()+"|";
            if(i == 2) str+="\n ";
            else if(i == 5) str+="\n ";
        }


        System.out.println(str);

    }

    public void remove2(int x,int y){

        Card first = playerhand.removeElementAt(playerhand.getCurrentSize()-1);
        System.out.println(first.toString()+" was removed!");
        Card second = playerhand.removeElementAt(playerhand.getCurrentSize()-1);
        System.out.println(second.toString()+" was removed!");
        System.out.println(deck.getCurrentSize());

    }

    public void fillUpPlayersHand(){
        int preSize = 9-playerhand.getCurrentSize();

        for(int i = 0 ; i< preSize;i++){
            Card x = deck.remove();
            playerhand.addNewEntry(x);
            System.out.println(x.toString()+" Added to the player hand!");

        }

    }

    //TO DO
    public void removeJQK(){
        //Should check if we have this JQK
    }

    //TO DO
    public void giveHint(){
        //check for JQK
        //Check 11
    }

    //TO Do
    public void checkJQK(CardStack<Card> faceUp){
        //check if the user have JQK faced up at the same time.Return boolean.

    }
    //Check for 11 TO DO
    public void check11(){
        // it will check if any of the combo of the number will make in sum 11.
    }

    //TO DO
    public void checkLost(){
        //we have to check if not check11() AND not checkJQK() than return true game won.
    }

    //To DO
    public boolean checkWin(){
        return deck.getCurrentSize() == 0;
    }



    public CardStack<Card> getDeck() {
        return deck;
    }

    public CardStack<Card> getPlayerhand() {
        return playerHand();
    }



}