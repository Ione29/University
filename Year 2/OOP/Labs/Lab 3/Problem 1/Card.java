public final class Card{
    public enum Rank{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KNIGHT, QUEEN, KING
    }

    public enum Suit{
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    private final Rank rank;
    private final Suit suit;

    public Card(Rank vRank, Suit vSuit){
        if(vRank == null)
            throw new RuntimeException("The rank must be non-null.");
        else if(vSuit == null)
            throw new RuntimeException("The suit must be non-null.");
        
        this.rank = vRank;
        this.suit = vSuit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public String toString(){
        String text = this.getRank() + " of " + this.getSuit();
        return text;
    }


}