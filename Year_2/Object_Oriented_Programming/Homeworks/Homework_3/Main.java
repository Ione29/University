import java.util.ArrayList;

public class Main {

    private static MiniDeck player1 = new MiniDeck();
    private static MiniDeck player2 = new MiniDeck();
    private static MiniDeck player3 = new MiniDeck();
    private static MiniDeck player4 = new MiniDeck(); 
    private static ArrayList<PlayingCard> facedown = new ArrayList<PlayingCard>();
    private static Deck deck = new Deck();

    public static void splitCards(Deck deck){
        for(int j = 0; j < 13; j++)
            player1.addToBottom(deck.getTopCard());
        for(int j = 0; j < 13; j++)
            player2.addToBottom(deck.getTopCard());
        for(int j = 0; j < 13; j++)
            player3.addToBottom(deck.getTopCard());
        for(int j = 0; j < 13; j++)
            player4.addToBottom(deck.getTopCard());
    }

    public static boolean checkForDuplicates(ArrayList<PlayingCard> cards){

        for(int i = 0; i < cards.size() - 1; i++)
            for(int j = i + 1; j < cards.size(); j++)
                if(cards.get(i).equals(cards.get(j)))
                    return true;

        return false;
    }


    public static void war(){

        //draw 1 from each player
        facedown.add(player1.getTopCard());
        facedown.add(player2.getTopCard());
        facedown.add(player3.getTopCard());
        facedown.add(player4.getTopCard());

        ArrayList<PlayingCard> faceup = new ArrayList<PlayingCard>();

        faceup.add(player1.getTopCard());
        faceup.add(player2.getTopCard());
        faceup.add(player3.getTopCard());
        faceup.add(player4.getTopCard());

        if(checkForDuplicates(faceup))
            war();
        else{
            giveTo(highCard(faceup), facedown);
            facedown.clear();
            System.out.println(highCard(faceup) + " won a war");
            faceup.clear();
        }
    }
    
    public static int highCard(ArrayList<PlayingCard> cards){
        PlayingCard highest; int position;
        highest = cards.get(0); position = 0;

        for(int i = 1; i < cards.size(); i++)
            if(cards.get(i).getRank().compareTo(highest.getRank()) > 0){
                highest = cards.get(i);
                position = i;
            }
        
        return position + 1;
    }

    public static void giveTo(int player, ArrayList<PlayingCard> cards){
        switch(player){
            case 1:
                for(PlayingCard card : cards)
                    player1.addToBottom(card);
                break;
            case 2:
                for(PlayingCard card : cards)
                    player2.addToBottom(card);
                break;
            case 3:
                for(PlayingCard card : cards)
                    player3.addToBottom(card);
                break;
            case 4:
                for(PlayingCard card : cards)
                    player4.addToBottom(card);
                break;
        }
    }

    public static void resetDecks(){
        player1.clearDeck();
        player2.clearDeck();
        player3.clearDeck();
        player4.clearDeck();
        deck.resetDeck();
    }

    public static void main(String[] args) {
        //for game statistics
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; 
        double average = 0;

        //for loop to play 10 games
        for(int n = 0; n < 10; n++){
            //preparing the game
            System.out.println("game " + n);
            int moves = 0;
            
            resetDecks();
            deck.shuffle();
            splitCards(deck);

            System.out.println("player 1");
            player1.display();
            System.out.println("player 2");
            player2.display();
            System.out.println("player 3");
            player3.display();
            System.out.println("player 4");
            player4.display();

            while(player1.getSize() != 0 && player2.getSize() != 0 && player3.getSize() != 0 && player4.getSize() != 0){
                moves++;
                ArrayList<PlayingCard> playedCards = new ArrayList<PlayingCard>();

                playedCards.add(player1.getTopCard());
                playedCards.add(player2.getTopCard());
                playedCards.add(player3.getTopCard());
                playedCards.add(player4.getTopCard());

                if(checkForDuplicates(playedCards) == true)
                    war();
                else{
                    System.out.println(highCard(playedCards) + " won the round");
                    giveTo(highCard(playedCards), playedCards);
                    
                }

            }

            if(moves < min)
                min = moves;
            else if(moves > max)
                max = moves;

            average += moves;
        }

        System.out.println("The shortest game was " + min + " moves long, the longest one " + max + " moves.");
        System.out.println("The average number of turns was " + (average / 10) + ".");
        
    }    
}

        