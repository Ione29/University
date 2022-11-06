import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {
    ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();

    //initialize deck (cards are ordered)
    public Deck(){
        for(PlayingCard.Suit suit : PlayingCard.Suit.values())
            for(PlayingCard.Rank rank : PlayingCard.Rank.values())
                cards.add(new PlayingCard(rank, suit));
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    //testing purposes only
    public void display(){
        for(PlayingCard card : cards)
            System.out.println(card.toString());
    }

    public void sort(){
        Collections.sort(cards,
                new Comparator<PlayingCard>(){
                    public int compare(PlayingCard c1, PlayingCard c2){
                        return c1.getRank().compareTo(c2.getRank());
                    }
                });

        Collections.sort(cards,
                new Comparator<PlayingCard>(){
                    public int compare(PlayingCard c1, PlayingCard c2){
                        if(c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit()){
                            throw new RuntimeException("There are two cards of type " + c1.getRank() + " of " + c1.getSuit());
                        }
                        return c1.getSuit().compareTo(c2.getSuit());
                    }
                });
    }

    public void addToBottom(PlayingCard card){
        cards.add(0, card);
    }

    public PlayingCard getTopCard(){
        return cards.remove(cards.size() - 1);
    }

    public int getSize(){
        return cards.size();
    }

    public void clearDeck(){
        cards.clear();
    }

    public void resetDeck(){
        cards.clear();

        for(PlayingCard.Suit suit : PlayingCard.Suit.values())
            for(PlayingCard.Rank rank : PlayingCard.Rank.values())
                cards.add(new PlayingCard(rank, suit));
    }
}
