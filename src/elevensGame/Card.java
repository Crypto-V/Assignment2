package elevensGame;

public class Card {
    private String cardSuit;
    private String cardRank;
    private int cardRate;

    public Card() {
        //Default constructor.
        cardRank = null;
        cardSuit = null;
        cardRate = 0;
    }

    public Card(String rank, String suit, int rate){
        //Overloaded constructor that takes rank,suit and rate and assigns
        // it to the object variables.
        cardSuit = suit;
        cardRank = rank;
        cardRate = rate;
    }

    public String getCardSuit() {
        //Return the suit of the card.
        return cardSuit;
    }

    public String getCardRank() {
        //Return the rank of the card.
        return cardRank;
    }

    public int getCardRate() {
        //Return the rate of the card.
        return cardRate;
    }

    public String toString() {
        //Return the string format of our output value.
            String str = "[";
            str += cardRank +" of "+cardSuit+" Rate: "+cardRate;
            str += "]";
            return str;
    }

}
