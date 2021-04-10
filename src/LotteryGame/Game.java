package LotteryGame;

import java.util.Scanner;
import java.util.Random;
public class Game{
    public static void main(String[] args) {
        int pot = 100;
        int ball1 = 0;
        int ball2 = 0;
        int ball3 = 0;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Lottery!");
        System.out.println("Lottery Pot: "+pot);

        System.out.println("\n Here's the possible options:\n1.Buy Ticket\n2.Watch the demo\n3.Exit");
        int option = input.nextInt();
        Machine mc = new Machine();
        Integer[] winNumbers ;
        int customerTicket = 0;

        switch (option){
            case 1:
                //To DO case buy ticket and start playing.
                System.out.println("How many tickets you want to buy?:");
                int ticketAmont = input.nextInt();
                while(ticketAmont > 0 ) {
                    System.out.println("In order to buy a ticket please enter your name: ");
                    String buyerName = input.nextLine();
                    String ticket = mc.buyTicket(buyerName, 5);
                    customerTicket= mc.getBall();
                    System.out.println(ticket + "\nYour ticket number is:" +customerTicket);
                    pot += 5;
                    ticketAmont--;
                }
                System.out.println("Ok lets start the lottery! ");
                System.out.println("Shuffling...");
                mc.shuffle(mc.gameBalls);
                System.out.println("Here are the numbers: ");
                //Print lucky numbers from that list
                winNumbers = luckyNumbers(mc.gameBalls,random);
                for (int i = 0;i<winNumbers.length;i++){
                    System.out.println(winNumbers[i]);
                    checkWin(pot,customerTicket,winNumbers[i]);
                }


                break;

            case 2:
                //Option for viewing demo.
                mc.getGameBalls();
                mc.shuffle(mc.gameBalls);
                String ticket = mc.buyTicket("Vasile",5);
                System.out.println(ticket);
                int x = mc.getBall();
                mc.removeBall(x);
                mc.getGameBalls();
                System.out.println("Finito!");
                break;
            case 3:
                //Exit.
                System.exit(1);
        }

    }
    public static Integer[] luckyNumbers(Ball[] balls,Random random){
        int x = balls[random.nextInt(30)].getBallNumber();
        int y = balls[random.nextInt(30)].getBallNumber();
        int z = balls[random.nextInt(30)].getBallNumber();
        return new Integer[]{x,y,z};

    }


    public static void checkWin(int pot,int x,int number){
            if (x == number) {
                double convertion = pot*0.6;
                System.out.println("You won "+convertion);
            }else if (x == number) {
                double convertion = pot * 0.3;
                System.out.println("You won " + convertion);
            }else if(x == number){
                double convertion = pot * 0.1;
                System.out.println("You won " + convertion);
            }else System.out.println("No match!");

    }


}
