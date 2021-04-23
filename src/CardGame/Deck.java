package CardGame;

public class Deck{

    private Card[] deck = new Card[52];
    private BagSet<Card> carddeck;

    //default constructor - creates an array of 52 cards
    public Deck(){
        for (int i = 0; i < deck.length; i++)
        {
            deck[i] = new Card();
        }
    }

    //To Do - Use Bagset to create the deck of cards
    //override constructor - Uses Bag concept to create deck of cards
    public  Deck(int capacity){
        carddeck = new BagSet<>(capacity);
        carddeck.addNewEntry(new Card());

    }

    public Card remove(){
        Card rcard = carddeck.remove();
        return rcard;
    }

    //TO Do - Complete the toString method to return all the cards in a deck
    public Card[] toArray(){

        Card [] dcards = (Card[])new Object[52];
        System.arraycopy(deck,1,dcards,0,52);
        return dcards;
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        for (Card c: myDeck.deck){
            System.out.println(c);
        }
    }
}
