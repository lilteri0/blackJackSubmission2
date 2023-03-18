

import java.util.Scanner;

public class Player extends Person {

    public Player() {
        super.setName("Player");

    }


    public void makeDecision(Deck deck, Deck usedCards, Scanner input) {

        int decision = 0;

        boolean getNum = true;

        while (getNum) {
            try {
                System.out.println("Would you like to: 1) Hit  2) Stand  3) Stop Playing");
                decision = input.nextInt();
                getNum = false;

            } catch (Exception e) {
                System.out.println("Invalid");
                input.next();
            }
        }

        if (decision == 1) {
            //hit the deck
            this.hit(deck, usedCards);
            if (this.getHand().calculatedValue() > 20) {
            } else {
                this.makeDecision(deck, usedCards, input);
            }

        } else if (decision == 3) {
            System.out.println("Thanks for playing.");
            System.exit(0);
        } else {
            System.out.println("You stand.");
        }


    }


}
