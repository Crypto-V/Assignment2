package elevensGame;

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

    private Card[] deck;
    private int numberOfcards = 0;
    final String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    final Integer[] cardrating = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    final String[] suitarray = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public Deck() {
        deck = new Card[52];
    }

    //This method will generate the 52 cards and will add it into our Card list.
    public void generateCards() {
        for (String suite : suitarray) {
            for (int i = 0; i < rankarray.length; i++) {
                deck[numberOfcards] = new Card(rankarray[i], suite, cardrating[i]);
                numberOfcards++;

            }
        }
    }

    public List<Card> getCards() {
        return Arrays.asList(deck);
    }

    public int getNumberOfcards() {
        return numberOfcards;
    }

    public void setNumberOfcards(int numberOfcards) {
        this.numberOfcards = numberOfcards;
    }

    //Shuffle method
    public void shuffle() {
        Random rng = new Random();

        for (int i = deck.length - 1; i > 0; i--) {
            // Swap the i-th card with a random one
            int j = rng.nextInt(i + 1);
            Card tmp = deck[j];
            deck[j] = deck[i];
            deck[i] = tmp;
        }
    }

    public Card getCard(int index){
        return deck[index];
    }

    //TO DO not working!!
    public boolean checkExistentCard(Card presentCard){
        for (Card card : deck) {
            if (card.getCardSuit().equals(presentCard.getCardSuit()) && card.getCardRank().equals(presentCard.getCardRank()))
                return true;
            else throw new NoSuchElementException("This card is not in the list!");
        }
        return false;
    }

    public Card removeCard(int index){
        Card removedCard = deck[index];
        deck[index] = null;
        numberOfcards--;
        return removedCard;
    }


    public static void main(String[] args) {
        Deck deck1 = new Deck();
        deck1.generateCards();
        System.out.println(deck1.getCards());
        deck1.shuffle();
        System.out.println(deck1.getCards());

        System.out.println(deck1.getNumberOfcards());
        System.out.println(deck1.getCard(8));
        System.out.println(deck1.checkExistentCard(deck1.getCard(8)));





    }


}
