package Practice;

public class Deck {
    private static Card[] deck = new Card[52];

    public Deck(){
        for(int i = 0;i<deck.length;i++){
            deck[i] = new Card();
            System.out.println("Added new card: "+deck[i].toString());
        }
    }

    public static void main(String[] args) {
        Deck dk1 = new Deck();
        for(Card car: deck){
            System.out.println(car);
        }
    }
}
