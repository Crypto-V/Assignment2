package Practice;

public class Human {
    String name;
    int age;
    int heightInInches;
    String eyecolor;

    public Human(String name, int age, int heightInInches, String eyecolor) {
        this.name = name;
        this.age = age;
        this.heightInInches = heightInInches;
        this.eyecolor = eyecolor;
    }

    public void speak(){
        System.out.println("Hello my name is "+name);
        System.out.println("I am "+heightInInches+" inches tall.");
        System.out.println("My eye color is "+eyecolor);
    }

    public void walk(){
        System.out.println("walking");
    }
    public void eat(){
        System.out.println("Eating");
    }

    public void work(){
        System.out.println("Working");
    }




}
