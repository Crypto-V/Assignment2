package elevensGame;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ListArrayTest {
    public static void main(String[] args) {


        CardListArray <Card> mylist = new CardListArray<>();

        Card card1 = new Card();

        mylist.add(card1);
        mylist.add(card1);
        mylist.add(card1);
        mylist.add(card1);
        System.out.println("List should be 1,2,3,4");
        System.out.println(Arrays.toString(mylist.toArray()));
        mylist.remove(2);
        System.out.println("removed 2");
        System.out.println(Arrays.toString(mylist.toArray()));


    }
}
