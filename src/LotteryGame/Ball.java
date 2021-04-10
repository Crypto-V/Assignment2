package LotteryGame;

public class Ball {
    private int ballNumber;


    public Ball(int number) {
        ballNumber = number;
    }

    public int getBallNumber(){
        return ballNumber;
    }

    public String toString(){
        return ballNumber+" ";
    }
}
