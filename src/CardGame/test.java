package CardGame;

public class test {
    public static void main(String[] args) {
        Card card1 = new Card();
        System.out.println(card1.getRank());
        System.out.println(card1.getiRank());

        var deck1 = new Deck();
        System.out.println(deck1.toString());
    }
}
