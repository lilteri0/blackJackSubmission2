public class Dealer extends Person {

    public Dealer() {

        super.setName("Dealer");

    }

    public void printFirstHand() {
        System.out.println("Dealer's hand:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is hidden.");
    }
}
