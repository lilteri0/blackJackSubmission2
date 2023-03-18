import java.util.Scanner;

public class GameEngine {

    private Deck deck, usedCards;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;


    public GameEngine(Scanner input) {


        deck = new Deck(true);

        usedCards = new Deck();

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        runGame(input);

    }


    private void runGame(Scanner input) {

        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().handToDeck(usedCards);
            player.getHand().handToDeck(usedCards);
        }

        if (deck.cardsLeft() < 4) {
            deck.reloadDeckFromUsedCards(usedCards);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();

        player.printHand();

        if (dealer.hasBlackjack()) {
            dealer.printHand();

            if (player.hasBlackjack()) {
                System.out.println("Player and Dealer have BlackJack. Push");
                pushes++;
                runGame(input);
            } else {
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                runGame(input);
            }
        }


        if (player.hasBlackjack()) {
            System.out.println("You have Blackjack! You win!");
            wins++;
            runGame(input);
        }

        player.makeDecision(deck, usedCards, input);

        if (player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21. You lose.");
            losses++;
            runGame(input);
        }

        dealer.printHand();
        while (dealer.getHand().calculatedValue() < 17) {
            dealer.hit(deck, usedCards);
        }

        if (dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts. You win!");
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose.");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
            System.out.println("You win!");
            wins++;
        } else {
            System.out.println("Push. Tie game.");
            pushes++;
        }

        runGame(input);
    }
}





