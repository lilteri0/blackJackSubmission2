import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    //An arraylist to hold the deck of Cards
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
    }

    public Deck(boolean makeDeck) {
        if (makeDeck) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Card card : deck) {
            output.append(card);
            output.append("\n");
        }
        return output.toString();
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard() {
        Card cardToTake = new Card(deck.get(0));

        deck.remove(0);

        return cardToTake;
    }

    public boolean hasCards() {
        return deck.size() > 0;
    }

    public int cardsLeft() {
        return deck.size();
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void emptyDeck() {
        deck.clear();
    }

    public void reloadDeckFromUsedCards (Deck used) {
        this.addCards(used.getCards());
        this.shuffle();
        used.emptyDeck();
        System.out.println("Making new deck from old cards");
    }


}
