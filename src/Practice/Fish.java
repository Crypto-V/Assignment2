package Practice;

public class Fish extends Animal {
    private String eyeColor;

    public Fish(int age, int weight, String gender, String eyeColor) {
        super(age, weight, gender);
        this.eyeColor = eyeColor;
    }

    @Override
    public void fly(){
        System.out.println("Sorry cant fly");
    }
}
