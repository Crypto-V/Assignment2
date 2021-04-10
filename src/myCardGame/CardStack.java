package myCardGame;

import CardGame.Card;

public class CardStack<T> implements CardStackInterface<T> {
    private  T[] deck;
    private int numOfEntries;
    private static final int def_capacity = 52;


    private boolean isArrayFull() {
        return (deck.length == numOfEntries);
    }

    public CardStack() {
        this(def_capacity);
    }

    public CardStack(int capacity) {
        T[] tempStack = (T[]) new Object[capacity];
        deck = tempStack;
        numOfEntries = 0;
    }

    public int getCurrentSize() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean addNewEntry(T newEntry) {
        if (isArrayFull()) return false;
        else {
            deck[numOfEntries++] = newEntry;
            return true;
        }
    }


    public T remove() {
        return null;
    }


    public boolean remove(T anEntry) {
        return false;
    }


    public void clear() {

    }


    public int getFrequencyOf(T anEntry) {
        return 0;
    }


    public boolean contains(T anEntry) {
        return false;
    }


    public T[] toArray() {
        T[] resultArray = (T[]) new Object[numOfEntries];
        System.arraycopy(deck, 0, resultArray, 0, numOfEntries);
        return resultArray;
    }

    public static void main(String[] args) {
        CardStack<String> stackOfCards = new CardStack<>(5);

        System.out.println("Adding Vasile..." + stackOfCards.addNewEntry("Vasile"));
        System.out.println("Adding Vasile..." + stackOfCards.addNewEntry("George"));
        System.out.println("Adding Vasile..." + stackOfCards.addNewEntry("Peter"));

        Object [] arrayOfNames = stackOfCards.toArray();

        for(Object name: arrayOfNames) System.out.println(name + " ....");
        System.out.println();

        //Video 2.3 minuta 16:23
    }
}
