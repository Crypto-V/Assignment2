package CardGame;

public class MyNode<T> {
    private T data;
    private MyNode<T> next;
    private MyNode<T> prev;

    //default constructor
    public MyNode (T datavalue) {
        data = datavalue;
        next = null;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T datavalue){
        data = datavalue;
    }

    public MyNode<T> getNext() { return next;}
    public MyNode<T> getPrev() { return prev;}

    public void setNext(MyNode<T> nextNode) { next = nextNode;}

    public static void main(String arg[])
    {
        MyNode<Integer> node1 = new MyNode<Integer>(1);
        MyNode<Integer> node2 = new MyNode<Integer>(3);
        MyNode<Integer> node3 = new MyNode<Integer>(5);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println("value of node1: " + node1.getData());
        System.out.println("value of node2: " + node1.getNext().getData());
        System.out.println("value of node3: " + node1.getNext().getNext().getData());
    }
}
