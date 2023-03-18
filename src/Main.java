import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Time for BlackJack");

        Scanner input = new Scanner(System.in);
        GameEngine blackjack = new GameEngine(input);

    }
}
