import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        MiniDeck player1 = new MiniDeck();
        MiniDeck player2 = new MiniDeck();
        MiniDeck player3 = new MiniDeck();
        MiniDeck player4 = new MiniDeck();
        Random random = new Random();
        int cardsLeft = 52;


        for(int i = 0; i < 4; i++)
            switch(i){
                case 0:
                for(int j = 0; j < 13; j++){
                    int randint = random.nextInt(cardsLeft--);
                    player1.add(deck.remove(randint));
                }
            }

    }
}
