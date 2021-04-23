package elevensGame;

public interface ListInterface<T> {

    public void add(T newEntry);
    /*Add new item to the end of the list,
    * the entries that are in the list already will not be affected,
    * the list size will be increased by one.*/

    public T remove(int position);
        /*
        * Remove the entry at the given position from the list.
        * List size will be decreased by one if will be successfully.
        *
        * Returns - reference to the removed item.
        *
        * If the position < 1 or position > getLength() throws exception.
        */


    public void clear();
    //Removes elements from the list.


    public T getEntry(int position);
    /*
    Retrieves an entry at the given int position.
    Return - reference to the the obj that match the index position.
    */

    public T[] toArray();
    /*
    Retrieves all the elements in the array in the order in which they appear in the list.

    Return - newly allocated array of all of the entries in the list.
    */

    public boolean isEmpty();

    /*
    Check if the list is empty and return the corresponding boolean value.
    */


    public int getLength();
    //Returns number of entries.


}
