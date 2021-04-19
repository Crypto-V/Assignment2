package Practice;

abstract class One{
    public One() {

    }
}

class Two extends One{
    public Two(){
        System.out.println("Two");
    }
}
class Test1{

    public static void main(String[] args) {
        Two two = new Two();
    }
}