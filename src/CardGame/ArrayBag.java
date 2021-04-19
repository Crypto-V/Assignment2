package CardGame;

import java.util.Random;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    private boolean isArrayfull(){
        return (bag.length == numberOfEntries);
    }

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0 ;

    }
//This is crazy_v
    //Tina 2 2563



    public int getCurrentSize(){
        return numberOfEntries;

    }
    /* method to return the size of the bag */

    public boolean isEmpty(){
        return false;

    }

    public boolean addNewEntry(T newEntry){
        if (isArrayfull()) {return false;}
        else
        {
            bag[numberOfEntries++] = newEntry;
            return true;
        }

    }

    public T remove(){
        //removes a bag entry randomly fromm the bag.

        Random rnd = new Random();
        int index = rnd.nextInt(numberOfEntries);

        T obj = bag[index];
        if (index < numberOfEntries) {
            System.arraycopy(bag, index + 1, bag, index, numberOfEntries - index  - 1);
        }
        numberOfEntries--;
        return obj;

    }

    public boolean remove(T anEntry){

        boolean result = false;
        //check if anEntry exists
        //remove from Bag
        if (getCurrentSize() > 0) {
            T[] inarray = this.toArray();
            for (int i = 0; i < getCurrentSize(); i++) {
                if (inarray[i].toString().equals(anEntry.toString())) {

                    T obj = bag[i];
                    if (i < numberOfEntries) {
                        System.arraycopy(bag, i + 1, bag, i, numberOfEntries - i  - 1);
                    }
                    numberOfEntries--;
                    result = true;
                }
            }
        }

        return result;

    }

    public void clear(){

    }

    public int getFrequencyOf(T anEntry){
        return 0;

    }

    public boolean contains(T anEntry){

        boolean result = false;
        //get values into Array
        //check for any valid entries before finding duplicate.
        int size = getCurrentSize();
        if (getCurrentSize() > 0) {
            T[] inarray = this.toArray();
            for (int i = 0; i < getCurrentSize(); i++) {
                if (inarray[i].toString().equals(anEntry.toString())) {
                    result = true;
                }
            }
        }
        return result;

    }

    public T[] toArray(){
        T[] resultarray = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultarray, 0, numberOfEntries);
        return resultarray;

    }

    public static void main (String[] args){
        ArrayBag<String> BagofArrays = new ArrayBag<String>(5);

        System.out.println("Output from professorVersion.ArrayBag.java");

        System.out.println("Adding Mark...... " + BagofArrays.addNewEntry("Mark"));
        System.out.println("Adding Jane...... " + BagofArrays.addNewEntry("Jane"));
        System.out.println("Adding John...... " + BagofArrays.addNewEntry("John"));
        System.out.println("Adding Lewis...... " + BagofArrays.addNewEntry("Lewis"));
        System.out.println("Adding Jenny...... " + BagofArrays.addNewEntry("Jenny"));

        Object[] arrayofNames = BagofArrays.toArray();
        for (Object name: arrayofNames)
        {
            System.out.print(name + "........");
            System.out.println();
        }

    }
}
