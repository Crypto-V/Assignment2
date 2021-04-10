package Practice;

public class Card {
    private static String cardRank;
    private static String cardSuit;
    private static Integer cardScore;

    public Card(){
        /*Each time the will call the card class a new card object will be constructed.
        * */
        String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Integer[] cardrating = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suitarray = {"H", "D", "S", "C"};

        for(int i =0;i<rankarray.length;i++){
            for (int j = 0;j<suitarray.length;j++){
                cardRank = rankarray[i];
                cardSuit = suitarray[j];
                cardScore = cardrating[i];
            }
        }
    }

    public static String getCardRank() {
        return cardRank;
    }

    public static void setCardRank(String cardRank) {
        Card.cardRank = cardRank;
    }

    public static String getCardSuit() {
        return cardSuit;
    }

    public static void setCardSuit(String cardSuit) {
        Card.cardSuit = cardSuit;
    }

    public static int getCardScore() {
        return cardScore;
    }

    public static void setCardScore(int cardScore) {
        Card.cardScore = cardScore;
    }

    public String toString(){
        return cardRank+" of "+cardSuit;
    }

}
