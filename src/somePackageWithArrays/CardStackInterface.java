package somePackageWithArrays;

public interface CardStackInterface <T> {
    public int getCurrentSize();
    /*Returns the number of elements currently contained in the stack*/

    public boolean isEmpty();
    /*Test for empty stack
    @return -(boolean) true if the number of elements is zero,false otherwise
    */

    public boolean addNewEntry(T newEntry);
    /*Test for spare capacity in the card stack and if exists, add new element
    and increment the number of elements in the bag

    @param (T) newEntry - the item to be added to the stack

    @return -(boolean) true if the item is added, false otherwise
    */

    public T remove();
    /*Remove any card from the card stack if it is available,
    and decrement the number of elements.Return the card that was removed or
    null if none is avalable.

    @return -(T) the element removed from the bag, or null.
    */

    public boolean remove(T anEntry);
    /*Remove the specified elemnet from the bag, if it is present, and decrement the number of elements.

    @return - (boolean) true if the element is available, false otherwise.
    */

    public void clear();
    /*Empty the card stack*/

    public int getFrequencyOf(T anEntry);
    /*count how many times a given element appears in the stack

    @param (T) anEntry - the card to look for in the stack

    @return - (int) the number of times that the given element appears
    */

    public boolean contains(T anEntry);
    /*check for the presence of the specified element in the cardStack

    @param (T) anEntry - the item to look for in the stack

    @return -(boolean) true if the bag contains the element,false otherwise
    */

    public T[] toArray();
    /*find all elements in the bag

    @return -(T[]) - an array of size number of elements, containing all cards from the stack.
    */



}
