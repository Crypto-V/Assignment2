package CardGame;

public class LinkedBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private MyNode<T> firstNode;
    private static final int DEFAULT_CAPACITY = 25;

    private boolean isArrayfull(){
        return (bag.length == numberOfEntries);
    }

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public LinkedBag(int capacity) {
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;

    }


    public int getCurrentSize(){
        return 0;

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

    public boolean addNewNode(T newEntry) {
        MyNode<T> newNode = new MyNode<T>(newEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    private MyNode findEntry(T entry) {
        MyNode currentNode = firstNode;
        boolean found = false;
        while (!found && currentNode != null) {
            if (currentNode.getData().equals(entry))
                found = true;
            else currentNode = currentNode.getNext();
        }
        if (found) return currentNode;
        else return null;
    }

    public boolean remove(T entry) {
        MyNode nodeToRemove = findEntry(entry);
        if (nodeToRemove == null) return false;
        nodeToRemove.setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true;
    }

    public T remove(){

        return null;

    }

    /*public boolean remove(T anEntry){

        return false;

    }*/

    public void clear(){

    }

    public int getFrequencyOf(T anEntry){
        return 0;

    }

    public boolean contains(T anEntry){
        return false;

    }

    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        MyNode<T> currentNode = firstNode;
        while (currentNode != null) {
            result[index++] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return result;
    }

}
