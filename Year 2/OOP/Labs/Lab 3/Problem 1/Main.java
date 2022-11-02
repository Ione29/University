public class Main {
    public static void main(String[] args) {
        Card c1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card c2 = new Card(Card.Rank.EIGHT, Card.Suit.HEARTS);
        Card c3 = new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS);
        Card c4 = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        Card c5 = new Card(Card.Rank.KNIGHT, Card.Suit.CLUBS);
        Card dupe = new Card(Card.Rank.FOUR, Card.Suit.SPADES);

        Hand hand = new Hand(c1);
        hand.addCard(c2);
        hand.addCard(c3);
        hand.addCard(c4);
        hand.addCard(c5);

        //display test and store test
        System.out.println("\nDisplay test:");
        hand.display();
        hand.store("hand.txt");

        //sort test
        System.out.println("\nSort Test:");
        hand.sort();
        hand.display();
        
        //remove test
        System.out.println("\nRemove Test:");
        if(hand.deleteCard(Card.Rank.ACE, Card.Suit.CLUBS) == true)
            System.out.println("Card removed succesfully!");
        else 
            System.out.println("Specified card could not be removed!");
        
        hand.display();
        
        //sort exception test should crash program
        System.out.println("\nSort Exception Test, should crash program:");
        hand.addCard(dupe);
        hand.sort();

    }
}
