package CardGame;

import java.util.Random;

public class Card  {

    private String rank;
    private Integer rate;
    private String suit;

    public Card(){

        //To Do - Complete Arrays to complete the card
        String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Integer[] cardrating = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suitarray = {"H", "D", "S", "C"};

        //randomly pick value from rank array and assign to rank variable
        Random rand = new Random();

        int rindex = rand.nextInt(13); //rindex can be between 0..13
        int sindex = rand.nextInt(4);  //sindex can be between 0..4

        //To Do - Complete constructor to assign values to rank, suit, rate,
        this.suit = suitarray[sindex];
        this.rank = rankarray[rindex];
        this.rate = cardrating[rindex];

    }

    //To Do -- Provide rest of getters and setters for the professorVersion.Card class


    public String getRank(){
        return rank;
    }

    public Integer getiRank() { return rate;}

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setIrank(Integer irank) {
        this.rate = irank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString(){

        if (rate == 11)
        {
            return "Jack" + " of " + suit;
        }
        else if (rate == 12)
        {
            return "Queen" + " of " + suit;
        }
        if (rate == 13)
        {
            return "King" + " of " + suit;
        }


        return rank + " of  " + suit;
    }

}
