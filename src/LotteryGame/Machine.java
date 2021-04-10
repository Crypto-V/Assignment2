package LotteryGame;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Machine {
    Ball[] gameBalls = new Ball[30];
    Random random = new Random();
    Scanner in = new Scanner(System.in);

    public Machine() {
        for(int i = 0;i<gameBalls.length;i++){
            Integer[] numbers= {1,2,3,4,5,6,7,8,9,10,
                    11,12,13,14,15,16,17,18,19,20,
                    21,22,23,24,25,26,27,28,29,30};;
            gameBalls[i] = new Ball(numbers[i]);
        }
    }


    //Create the method to get the initial list before shuffling.
    public void getGameBalls() {
        String str = "{";
        for(Ball ball:gameBalls){
            str += ball;
        }
        str += "}";
        System.out.println(str);
    }


    //Create method to shuffle the list when called.
    public void shuffle(Ball[] ballList){

        for(int i = 0;i<ballList.length;i++){
            int index = random.nextInt(i+1);

            Ball a = ballList[index];
            ballList[index] = ballList[i];
            ballList[i] = a;

        }
    }
    //Create a method to remove the ball from the list
    public void removeBall(int number){
        for(int i = 0;i<gameBalls.length;i++){
            if(gameBalls[i].getBallNumber() == number){
                gameBalls[i]=null;
            }
        }
    }

    //Create a method to return a random number from the shuffled lsit;
    public int getBall(){
        return gameBalls[random.nextInt(30)].getBallNumber();
    }

    //Create a method to sell the ticket for the price of five $.

    public String buyTicket(String name,int amount){
        while(name.equals("")){
            System.out.println("Name can't be empty");
            System.out.println("Enter your name: ");
            name = in.next();
        }
        String str = "[ ";
        if (amount > 5 ){
            System.out.println("You're paying to much, i have no change!");
        }else if(amount<5) {
            System.out.println("Not enough money for the ticket");
        }
        else {
            Date date = new Date();
            str += "Succes! Ticket for Name: "+name+"\nAmount: "+amount+"\nOn: "+date;
        }
        return str;
    }


}
