package CardGame;

import java.util.Scanner;

public class CardTest {

    public static void main(String[] args){

        Deck carddeck = new Deck(52);
        System.out.println("professorVersion.Card professorVersion.Deck: ........");
        System.out.println(carddeck.toString());

        //remove nine cards from the deck. Pass them to the player

        BagSet<Card> playerhand = new BagSet(9);
        for (int i = 0; i < 9; i++)
        {
            playerhand.addNewEntry(carddeck.remove());
        }

        String gresult = "WON";
        int cd2 = 0;

        while (playerhand.isEmpty() == false && (!gresult.equals("WON"))  && cd2 < 9) {
            //show hand
            System.out.println("Player hand......");
            Object[] arrayofNames = playerhand.toArray();
            for (Object card: arrayofNames)
            {
                System.out.print(card.toString() + ", ");
                //System.out.println();
            }
            System.out.println();

            //Check deck after dealing to player
            /*System.out.println("professorVersion.Card professorVersion.Deck after dealing: ........");
            System.out.println(carddeck.toString());*/


            //Get input from the user to select the cards to be removed
            System.out.println("Please enter the card positions [0-8] to be removed");
            // Using Scanner for Getting Input from User
            Scanner in = new Scanner(System.in);
            int cd1 = in.nextInt();
            cd2 = in.nextInt();

            if (cd2 > 8)
                break;
            //read playerhand as an array and add two values
            //check if total is 11, then remove those values.
            Object[] cardarray = playerhand.toArray();
            Card crd1 = (Card)cardarray[cd1];
            Card crd2 = (Card)cardarray[cd2];
            if ( (crd1.getiRank() + crd2.getiRank()) == 11) {
                playerhand.remove(crd1);
                playerhand.remove(crd2);
                for (int i = 0; i < 2; i++) {
                    playerhand.addNewEntry(carddeck.remove());
                }
            }
        }

    }


}
