import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //print out a welcome message
        System.out.println("Time for BlackJack");

        Scanner input = new Scanner(System.in);
        GameEngine blackjack = new GameEngine(input);

    }
}
