/*Software Development II. Assignment 2
 *Cards Game: Elevens
 *Student: Vasile Verejan
 *Student: Jatan Patel
 *Teacher: Zeeshan Chaudhry
 */
package elevensGame;

import java.util.Arrays;

public class Deck {

    /*
     * This class will be responsible for creating the deck of 52 unique cards,
     * we should be able to add new cards, remove cards and many more other useful functions.
     */

    private CardStack<Card> deck;
    private CardStack<Card> playerhand;
    private CardStack<Object> replay;
    public int numberOfcards = 0;
    final String[] rankarray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    final Integer[] cardrating = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    final String[] suitarray = {"H", "D", "S", "C"};

    public Deck() {
        /*When the instance of the deck will be created,constructor automatically will instantiate
        this 3 arrays of CardStack data type.
        First one will represent the actual deck of cards.
        Second will be the cards that will be faceUp.
        Third will be the array that will store all the movements we make add or remove, this will be of
        default capacity which is 10000.
        */
        deck = new CardStack<>(52);
        playerhand = new CardStack<>(9);
        replay = new CardStack<>();
    }

    public void generateCards() {
        /*
         * This method will generate the unique number of cards(52)
         * that will be inserted into our CardStack variable deck.
         * When called it will shuffle the cards directly to avoid calling the method repeatably.
         */
        for (String suite : suitarray) {
            for (int i = 0; i < rankarray.length; i++) {
                deck.addNewEntry(new Card(rankarray[i], suite, cardrating[i]));
                numberOfcards++;
            }
        }
        System.out.println("Cards generated and cards where shuffled!");
        deck.shuffle();
    }

    public void playerHand() {
        /*
         * This method will get the first 9 elements of the shuffled deck.
         * And it will populate our player hand with the removed cards.
         *@returns - playerhand of a type CardStack<Cards>
         */

        for (int i = 0; i < 9; i++) {
            playerhand.addNewEntry(deck.remove());
        }
    }

    public void printTable() {
        /*
         *This method will be responsable for printing the example table
         * plus our playerhand cards faced up.
         */

        System.out.println("\nFollow the example table index to remove elements!");
        System.out.println("|1|2|3|\n|4|5|6|\n|7|8|9|\n");

        //As soon as the index will be 2 or 5 the cursor will move to the new line
        // which will make our table to look like a matrice of 3x3.

        System.out.println("Actual Table!");
        StringBuilder str = new StringBuilder("|");
        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            str.append(playerhand.getElementById(i).getCardRank()).append(playerhand.getElementById(i).getCardSuit()).append("|");
            if (i == 2) str.append("\n|");
            else if (i == 5) str.append("\n|");
        }
        //Finally it will print the actual matrix representation of the playerhand.
        System.out.println(str);
    }

    public void remove2(int x, int y) {

        //Try catch block will be used to control that value of x and y are between 1-9.
        //In case it will not follow the rule the NullPointer exception will be controlled
        // and will get the custom answer on how to correct the input.
        try {
            //This method will remove 2 cards from the player hand if in sum will make 11,
            //which automatically is filtering the J Q K cards since the value of each card is above 11.
            int xValue = playerhand.getElementById(x - 1).getCardRate();
            int yValue = playerhand.getElementById(y - 1).getCardRate();
            int sum = xValue + yValue;

            Card first = playerhand.getElementById(x - 1);
            Card second = playerhand.getElementById(y - 1);

            //If the cards the were passed will make in sum 11 program
            // will continue to removing the cards from the deck.
            //else it will display that numbers don't make 11 in sum.
            //replay.addNewEntry() will be called when will be necessary to add movement into our replay array.
            if (sum == 11) {
                playerhand.remove(first);
                String str1 = first.toString() + " was removed!";
                replay.addNewEntry(str1);
                System.out.println(str1);

                playerhand.remove(second);
                String str2 = second.toString() + " was removed!";
                replay.addNewEntry(str2);
                System.out.println(str2);


                fillUpPlayersHand();
            } else {
                System.out.println("Numbers you entered doesn't make 11 in sum! ");
            }

        } catch (NullPointerException e) {
            System.out.println("\nWrong number entered! Please insert a valid number from 1-max cards faced up!!");
        }
    }

    public void removeJQK(int x, int y, int z) {
        //Try catch block will be used to control that value of x and y are between 1-9.
        //In case it will not follow the rule the NullPointer exception will be controlled
        // and will get the custom answer on how to correct the input.
        try {
            boolean jqkCheck = checkJQK(); //getting the result of the method for later use.
            //Getting the card objects that are stored at the x,y,z position.
            Card first = playerhand.getElementById(x - 1);
            Card second = playerhand.getElementById(y - 1);
            Card third = playerhand.getElementById(z - 1);

            //Creating the list that will store the ranks of those 3 cards for further validation use.

            String[] rankList = new String[]{first.getCardRank(), second.getCardRank(), third.getCardRank()};
            int validationNumber = 0;

            //If the validationNumber will be equal to 3 that means that we have one of each J, Q, K.
            for (String s : rankList) {
                if (s.equals("K") || s.equals("Q") || s.equals("J")) {
                    validationNumber++;
                }
            }

            //This if statemt will run and remove the elements only if we know that there are JQK faced up
            //and if their indexes were correct inserted by the user.
            if (jqkCheck && validationNumber == 3) {
                //Calling the remove method which return the obj that was removed.
                //Storing the movement into the replay array.
                //And printing it for user use and knowledge.
                playerhand.remove(first);
                String str1 = first.toString() + " was removed!";
                replay.addNewEntry(str1);
                System.out.println(str1);

                playerhand.remove(second);
                String str2 = second.toString() + " was removed!";
                replay.addNewEntry(str2);
                System.out.println(str2);

                playerhand.remove(third);
                String str3 = third.toString() + " was removed!";
                replay.addNewEntry(str3);
                System.out.println(str3);

                fillUpPlayersHand();

            } else System.out.println("No JQK combo founded!Or wrong number was placed! Try Again!!");
        } catch (NullPointerException ex) {
            //In case of NullPointerException user will get a message that one of the indexes he entered are wrong.
            System.out.println("\nWrong number entered! Please insert a valid number from 1-max cards faced up!!");
        }
    }

    public void fillUpPlayersHand() {
        //Since we know that we have 9 cards faceUp we will subtract from 9 the current size of player hand
        //and we will fill up the amount of cards that the user is missing.
        int preSize = 9 - playerhand.getCurrentSize();
        for (int i = 0; i < preSize; i++) {
            if (deck.getCurrentSize() != 0) {
                Card x = deck.remove();
                playerhand.addNewEntry(x);
                String str = x.toString() + " < + > Added to the player hand!";
                //Storing the new entry that was added to the replay array.
                replay.addNewEntry(str);
                System.out.println(str);

            } else {
                break;
            }

        }
        String str1 = "Cards in deck: ( " + deck.getCurrentSize() + " )\n";
        replay.addNewEntry(str1);
        System.out.println(str1);
    }

    public boolean giveHint() {
        /*
         * This method will check initially if we don't have any JQK combination in our faceUp cards,
         * in case of match we will display the possible movements to the user.
         *
         * In case there will not be any JQK combination the program will execute the second part of the method
         * where it player hand will be checked for all possible combinations that make in sum 11
         * and will display to the user.
         *
         * In case of no match in both cases program will terminate will the message
         * System.out.println("No available hints!!!Game Lost!"); and will return false for further use.
         */

        System.out.println("___________________________________");
        System.out.println("|The list of possible combinations!|");
        System.out.println("|__________________________________|");
        if (checkJQK()) {
            int kCount = 0;
            int kIndex = 0;
            int qCount = 0;
            int qIndex = 0;
            int jCount = 0;
            int jIndex = 0;

            for (int i = 0; i < playerhand.getCurrentSize(); i++) {
                switch (playerhand.getElementById(i).getCardRank()) {
                    case "K":
                        kIndex = i;
                        kCount++;
                        break;
                    case "Q":
                        qIndex = i;
                        qCount++;
                        break;
                    case "J":
                        jIndex = i;
                        jCount++;
                        break;
                }

                if (kCount > 0 && qCount > 0 && jCount > 0) {
                    System.out.println("Card" + playerhand.getElementById(kIndex).toString() + " at index " + (kIndex + 1));
                    System.out.println("Card" + playerhand.getElementById(qIndex).toString() + " at index " + (qIndex + 1));
                    System.out.println("Card" + playerhand.getElementById(jIndex).toString() + " at index " + (jIndex + 1));
                    System.out.println();
                    return true;

                }
            }

        } else if (check11()) {

            for (int i = 0; i < playerhand.getCurrentSize(); i++) {
                for (int j = 0; j < playerhand.getCurrentSize(); j++) {
                    int sum = playerhand.getElementById(i).getCardRate() + playerhand.getElementById(j).getCardRate();
                    if (sum == 11) {
                        System.out.println("Card" + playerhand.getElementById(i).toString() + " at index " + (i + 1));
                        System.out.println("Card" + playerhand.getElementById(j).toString() + " at index " + (j + 1));
                        System.out.println("Can be removed!!");
                        return true;
                    }
                }
            }

        } else {
            System.out.println("No available hints!!!Game Lost!");
            return false;
        }

        System.out.println("####################################");
        return false;
    }

    public boolean checkJQK() {
        //This method simply returns true if we have JQK combo in our hand.
        //Otherwise it return false.
        int kCount = 0;
        int qCount = 0;
        int jCount = 0;

        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            switch (playerhand.getElementById(i).getCardRank()) {
                case "K":
                    kCount++;
                    break;
                case "Q":
                    qCount++;
                    break;
                case "J":
                    jCount++;
                    break;
            }
            //If any of the counters will be still 0 this mean that there are no any JQK combinations.
            if (kCount > 0 && qCount > 0 && jCount > 0) return true;
        }
        return false;

    }

    public boolean check11() {
        /*
        Using 2 for loops to check for any possible combinations that will make 11 in sum
        @Returns true if found, otherwise false.
         */
        for (int i = 0; i < playerhand.getCurrentSize(); i++) {
            for (int j = 0; j < playerhand.getCurrentSize(); j++) {
                int sum = playerhand.getElementById(i).getCardRate() + playerhand.getElementById(j).getCardRate();
                if (sum == 11) return true;
            }
        }
        return false;
    }

    public Integer[] demo() {
        /*
        Returning list of type integer plays a very important role in this method.
        First in case we found the JQK combination in our playerhand we will get their indexes
        and will store it in the list ,and the size will be set to 3 for further use in the main method.

        After program will check for 11 combination and will insert the index of the elements that makes 11 in sum
        into our list and the size will be set to 2.
         */
        int size = 0;
        Integer[] ourIndexes = new Integer[size];

        if (checkJQK()) {
            int kCount = 0;
            int kIndex = 0;
            int qCount = 0;
            int qIndex = 0;
            int jCount = 0;
            int jIndex = 0;

            for (int i = 0; i < playerhand.getCurrentSize(); i++) {
                switch (playerhand.getElementById(i).getCardRank()) {
                    case "K":
                        kIndex = i;
                        kCount++;
                        break;
                    case "Q":
                        qIndex = i;
                        qCount++;
                        break;
                    case "J":
                        jIndex = i;
                        jCount++;
                        break;
                }

                if (kCount > 0 && qCount > 0 && jCount > 0) {
                    ourIndexes = new Integer[]{kIndex + 1, qIndex + 1, jIndex + 1};
                    size += 3;
                }
            }

        } else if (check11()) {

            for (int i = 0; i < playerhand.getCurrentSize(); i++) {
                for (int j = 0; j < playerhand.getCurrentSize(); j++) {
                    int sum = playerhand.getElementById(i).getCardRate() + playerhand.getElementById(j).getCardRate();
                    if (sum == 11) {
                        ourIndexes = new Integer[]{i + 1, j + 1};
                        size += 2;
                    }
                }
            }
        }
        //returning the list of indexes the will help us to remove the elements from the playerhand automatically.
        return ourIndexes;
    }

    public boolean win() {
        //This method return true if the deck size is 0 AND if there are no cards in the playerhand.
        return deck.getCurrentSize() == 0 && playerhand.getCurrentSize() == 0;

    }

    public CardStack<Object> getReplay() {
        return replay;
    }

}