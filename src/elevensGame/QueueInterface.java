public interface QueueInterface<T>{

    public void enqueue(T newEntry);
    // add new entry to the back of the queue

    public T dequeue();

    // remove entry from the front of the queue

    public T getFront();
    //return, but don't remove the entry from the front of the queue
    public boolean isEmpty();
    // return true if empty, false otherwise
    public void clear();
    // remove all entries from the queue


}

