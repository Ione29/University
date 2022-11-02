public class PlayingCard {
    enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    enum Rank{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    private Rank rank;
    private Suit suit;

    public PlayingCard(Rank vRank, Suit vSuit) {
        
        if(vRank == null)
            throw new IllegalArgumentException("Rank cannot be null!");
        else if (vSuit == null)
            throw new IllegalArgumentException("Suit cannot be null!");
        
        this.rank = vRank;
        this.suit = vSuit;
    }
    
    public Rank getRank() {
        return this.rank;
    }
    
    public Suit getSuit() {
        return this.suit;
    }
    
    public String toString(){
        String text = this.rank + " of " + this.suit;
        return text;
    }
    
}