package Practice;

public class Bird extends  Animal{
    private int wingSize;

    public Bird(int age, int weight, String gender, int wingSize) {
        super(age, weight, gender);
        this.wingSize = wingSize;
    }

    public void fly(){
        System.out.println("Flying...");
    }
}
