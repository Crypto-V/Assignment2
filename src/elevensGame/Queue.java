package elevensGame;

public class Queue<T> implements QueueInterface<T>{
    private MyNode<T> front, rear;

    public Queue(){
        front = null;
        rear = null;
    }
    public void enqueue(T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if (front == null){
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public T dequeue(){
        if ( front == null ) return null;
        else{
            T valueToReturn = front.getData();
            front = front.getNext();
            if ( front == null) rear = null;
            return valueToReturn;
        }

    }

    public T getFront(){
        if (front == null) return null;
        else return front.getdata();
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void clear(){
        front = null;
        rear = null;

    }

    public static void main (String[] args){
        Queue<String> queue = new Queue<String>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        for (int i=1; i<=4; i++ ){
            System.out.println("get front = "+ queue.getFront());
            System.out.println("Deque = " + queue.dequeue());
        }
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        System.out.println("Queue empty is " + queue.isEmpty());
        queue.clear();
        System.out.println("Queue empty is " + queue.isEmpty());
    }
}