package CardGame;

public class BagSet<T> extends ArrayBag<T> {


    private int value;

    public BagSet(int capacity){
        super(capacity);
    }

    @Override
    public boolean addNewEntry(T newEntry){

        boolean result = false;
        //use getFrequencyOf() method to check if an element exists
        //if >0 -> return false
        //if 0 -> addNewEntry.

        if (contains(newEntry))
        {
            result = false;
        }
        else
        {
            result = super.addNewEntry(newEntry);
            //result = true;
        }


        return result;
    }

    //question a
    public BagSet<T> union(BagSet<T> anotherBagset){
        int maxsize = anotherBagset.getCurrentSize();
        BagSet<T> ubag = new BagSet<T>(maxsize);

        T[] thisBagset = this.toArray();

        //for each element in thisBagset, check anotherBagset
        //if anotherBagset contains the element, then add to
        //unionBag

        for (int i = 0; i < thisBagset.length; i++)
        {
            if (anotherBagset.contains(thisBagset[i]))
            {
                ubag.addNewEntry(thisBagset[i]);
            }
        }

        return ubag;
    }

    //question c
    public BagSet<T> difference(BagSet<T> anotherBagset){
        int maxsize = this.getCurrentSize();
        BagSet<T> unionBag = new BagSet<T>(maxsize);

        T[] thisBagset = this.toArray();

        //for each element in thisBagset, check anotherBagset
        //if anotherBagset does not contains the element, then add to
        //unionBag

        for (int i = 0; i < thisBagset.length; i++)
        {
            if (!anotherBagset.contains(thisBagset[i]))
            {
                unionBag.addNewEntry(thisBagset[i]);
            }
        }

        return unionBag;
    }

    //question d
    public boolean equals(BagSet<T> anotherBagset){
        boolean result = true;

        T[] thisBagset = this.toArray();

        for (int i = 0; i < thisBagset.length; i++)
        {
            if (!anotherBagset.contains(thisBagset[i]))
            {
                result = false;
            }
        }

        return result;
    }


}
