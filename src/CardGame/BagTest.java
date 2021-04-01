package CardGame;

public class BagTest {
    public static void main(String[] args)
    {
        System.out.println("Output from professorVersion.BagTest.java");

        LinkedBag<String> lblinklist = new LinkedBag<String>();

        /*System.out.println("Adding Mark...... " + lblinklist.addNewNode("Mark"));
        System.out.println("Adding Jane...... " + lblinklist.addNewNode("Jane"));
        System.out.println("Adding John...... " + lblinklist.addNewNode("John"));
        System.out.println("Adding Lewis...... " + lblinklist.addNewNode("Lewis"));
        System.out.println("Adding Jenny...... " + lblinklist.addNewNode("Jenny"));

        Object[] arrayofNames = lblinklist.toArray();
        for (Object name: arrayofNames)
        {
            System.out.print(name + "........");
            System.out.println();
        }*/

        BagSet<Integer> bg1 = new BagSet<Integer>(5);
        boolean addresult = true;
        addresult = bg1.addNewEntry(1);
        System.out.println("result after bg1 first entry: " + addresult);
        addresult = bg1.addNewEntry(2);
        System.out.println("result after bg1 second entry: " + addresult);
        addresult = bg1.addNewEntry(3);
        System.out.println("result after bg1 third entry: " + addresult);
        addresult = bg1.addNewEntry(4);
        System.out.println("result after bg1 fourth entry: " + addresult);
        addresult = bg1.addNewEntry(5);
        System.out.println("result after bg1 fifth entry: " + addresult);

        BagSet<Integer> bg2 = new BagSet<Integer>(4);
        boolean addresult2 = true;
        addresult2 = bg2.addNewEntry(1);
        System.out.println("result after bg2 first entry: " + addresult2);
        addresult2 = bg2.addNewEntry(2);
        System.out.println("result after bg2 second entry: " + addresult2);
        addresult2 = bg2.addNewEntry(3);
        System.out.println("result after bg2 third entry: " + addresult2);
        addresult2 = bg2.addNewEntry(3);
        System.out.println("result after bg2 fourth entry: " + addresult2);

        BagSet<Integer> diffbag;

        diffbag = bg1.difference(bg2);

        System.out.println("Size of diffbag: " + diffbag.getCurrentSize());

        Object[] arrayofdiffbag = diffbag.toArray();

        for (Object myint: arrayofdiffbag)
        {
            System.out.print(myint + "........");
            System.out.println();
        }

        BagSet<Integer> unionbag;

        unionbag = bg1.union(bg2);

        System.out.println("Size of unionbag: " + unionbag.getCurrentSize());

        Object[] arrayofunionbag = unionbag.toArray();

        for (Object unint: arrayofunionbag)
        {
            System.out.print(unint + "........");
            System.out.println();
        }

        System.out.println("Check for Equal: " + bg1.equals(bg2));


    }





}
