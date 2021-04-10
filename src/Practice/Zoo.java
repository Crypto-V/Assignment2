package Practice;

public class Zoo {
    public static void main(String[] args) {
        Animal animal1 = new Animal(23,123,"male");
        animal1.fly();

        Animal animal2 = new Fish(23,123,"male","red");
        animal2.fly();

        Animal animal3 = new Bird(23,123,"male",123);
        animal3.fly();

    }
}
