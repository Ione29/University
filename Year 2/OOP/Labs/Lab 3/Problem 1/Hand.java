import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;

public class Hand implements Storable{
    
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Hand(Card c){
        cards.add(c);
    }

    public void addCard(Card c){
        cards.add(c);
    }

    public boolean deleteCard(Card.Rank vRank, Card.Suit vSuit){
        
        for(Card card : cards){
            if(card.getRank() == vRank && card.getSuit() == vSuit){
                cards.remove(card);
                return true;
            }
        }

        return false;

    }

    public void sort(){
        Collections.sort(cards,
                new Comparator<Card>(){
                    public int compare(Card c1, Card c2){
                        return c1.getRank().compareTo(c2.getRank());
                    }
                });

        Collections.sort(cards,
                new Comparator<Card>(){
                    public int compare(Card c1, Card c2){
                        if(c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit()){
                            throw new RuntimeException("There are two cards of type " + c1.getRank() + " of " + c1.getSuit());
                        }
                        return c1.getSuit().compareTo(c2.getSuit());
                    }
                });
    }

    public void display(){
        for(Card c : cards){
            System.out.println(c.toString());
        }
    }

    public void store(String fileName){
        try{
            FileWriter writer = new FileWriter(fileName);
            for(Card c : cards)
                writer.write(c.toString() + "\n");
            writer.close();
        }catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
