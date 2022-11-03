import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double mean;
        for(int n = 0; n < 10; n++){
            //preparing the game
            Deck deck = new Deck();
            MiniDeck player1 = new MiniDeck();
            MiniDeck player2 = new MiniDeck();
            MiniDeck player3 = new MiniDeck();
            MiniDeck player4 = new MiniDeck(); 
            deck.shuffle();
            int moves = 0;

            for(int i = 0; i < 4; i++)
                switch(i){
                    case 0:
                    for(int j = 0; j < 13; j++){
                        player1.addToBottom(deck.getTopCard());
                    }
                    break;
                    case 1:
                    for(int j = 0; j < 13; j++){
                        player2.addToBottom(deck.getTopCard());
                    }
                    break;
                    case 2:
                    for(int j = 0; j < 13; j++){
                        player3.addToBottom(deck.getTopCard());
                    }
                    break;
                    case 3:
                    for(int j = 0; j < 13; j++){
                            player4.addToBottom(deck.getTopCard());
                        }
                        break;
                    }
                    
                    
            while(player1.getSize() != 0 && player2.getSize() != 0 && player3.getSize() != 0 && player4.getSize() != 0){
                moves++;
                PlayingCard player1Card, player2Card, player3Card, player4Card;
                
            }
        }    
    }
}
        