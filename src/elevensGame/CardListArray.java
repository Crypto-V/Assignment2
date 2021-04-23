package elevensGame;

public class CardListArray<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private int capacity;
    private final int Default_Size = 52;

    public CardListArray(){
        T[] tempList = (T[]) new Object[Default_Size];
        numberOfEntries = 0;
        list = tempList;
        capacity = Default_Size;
    }

//    private void addCapacity(){
//        capacity += Default_Size;
//        list = Arrays.copyOf(list,capacity+1);
//    }


    public void add(T newEntry) {
        if(numberOfEntries < Default_Size){
            numberOfEntries++;
            list[numberOfEntries] = newEntry;
        }else throw new IndexOutOfBoundsException("No more space in the array!");


    }


    public T remove(int position) {
        if(position >= 1 && position <= numberOfEntries){
            T valueToReturn = list[position];
            for(int i = position; i<numberOfEntries;i++) list[i] = list[i+1];
            numberOfEntries--;
            return valueToReturn;
        }else throw new IndexOutOfBoundsException("Remove position is out of range!");
    }


    public void clear() {
        numberOfEntries = 0;
    }


    public T getEntry(int position) {
        if(position >= 1 && position <= numberOfEntries){
            return list[position];

        }else throw new IndexOutOfBoundsException("getEntry position is out of bounds ");
    }


    public T[] toArray() {
        T[] arr = (T[])new Object[numberOfEntries];
        System.arraycopy(list,1,arr,0,numberOfEntries);
        return arr;
    }


    public boolean isEmpty() {
        if(numberOfEntries == 0) return true;
        else return false;
    }

    public int getLength(){
        return numberOfEntries;
    }
}
