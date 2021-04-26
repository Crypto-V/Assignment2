package elevensGame;

import java.util.Random;

public final class CardStack<T> implements CardStackInterface<T> {
    private T[] deck;
    private int numOfEntries;
    private static final int def_capacity = 52;
    private boolean initialised = false;
    private static final int MAX_CAPACITY = 10000;

    public T getElementById(int index) {
        T result = null;
        if (!isEmpty() && index >= 0 && index < numOfEntries) {
            result = deck[index];
        }
        return result;
    }

    public void shuffle() {
        //Shuffle method will shuffle cards based on random value.
        Random rng = new Random();

        for (int i = deck.length - 1; i > 0; i--) {
            // Swap the i-th card with a random one
            int j = rng.nextInt(i + 1);
            T tmp = deck[j];
            deck[j] = deck[i];
            deck[i] = tmp;
        }
    }

    private boolean isArrayFull() {
        return (deck.length == numOfEntries);
    }

    private void checkInitialisation() {
        if (!initialised)
            throw new SecurityException("CardStack was not initialised properly!");
    }

    public T removeElementAt(int index) {
        T result = null;
        if (!isEmpty() && index >= 0 && index < numOfEntries) {
            result = deck[index];
            deck[index] = deck[numOfEntries - 1];
            deck[numOfEntries - 1] = null;
            numOfEntries--;
        }
        return result;
    }

    public CardStack() {
        this(def_capacity);
    }

    public CardStack(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            T[] tempStack = (T[]) new Object[capacity];
            deck = tempStack;
            numOfEntries = 0;
            initialised = true;
        } else throw new IllegalStateException("Attempt to create a bag where the capacity is too high!");

    }

    public int getCurrentSize() {
        return numOfEntries;
    }

    public boolean isEmpty() {
        return (numOfEntries == 0);
    }

    public boolean addNewEntry(T newEntry) {
        checkInitialisation();
        if (isArrayFull()) return false;
        else {
            deck[numOfEntries++] = newEntry;
            return true;
        }
    }

    public T remove() {
        checkInitialisation();
        return removeElementAt(numOfEntries - 1);
    }

    public boolean remove(T anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && index < numOfEntries)
            if (deck[index].equals(anEntry)) found = true;
            else index++;
        if (found) removeElementAt(index);
        return found;
    }

    public void clear() {
        while (!isEmpty()) remove();

    }

    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numOfEntries - 1; i++)
            if (deck[i].equals(anEntry)) count++;
        return count;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && index < numOfEntries) {
            if (deck[index++].equals(anEntry)) found = true;
        }
        return found;
    }

    public T[] toArray() {
        T[] resultArray = (T[]) new Object[numOfEntries];
        System.arraycopy(deck, 0, resultArray, 0, numOfEntries);
        return resultArray;
    }

}
