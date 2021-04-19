package elevensGame;

public class Card {
    private String cardSuit;
    private String cardRank;
    private int cardRate;

    public Card() {

    }

    public Card(String suit, String rank, int rate){
        cardSuit = suit;
        cardRank = rank;
        cardRate = rate;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardRank() {
        return cardRank;
    }

    public int getCardRate() {
        return cardRate;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardRank(String cardRank) {
        this.cardRank = cardRank;
    }

    public void setCardRate(int cardRate) {
        this.cardRate = cardRate;
    }

    public String toString() {
        String str = "[";
        str += cardSuit +" of "+cardRank+" .Card Rate: "+cardRate;
        str += "]";
        return str;
    }
}
