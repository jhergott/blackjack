package blackjack;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stub {

    public static void main(String[] args) {

        DeckShoe deckShoe = new DeckShoe();

        for(int i = 0; i < 300; i++){
            deckShoe.dealCard();
        }

        System.out.println("Rest of Deck:");
        deckShoe.showDeck();


        System.out.println("New Shoe:");
        deckShoe.newShoe();
        deckShoe.showDeck();


    }
}
