package blackjack;

import java.util.ArrayList;

/**
 * Created by jakehergott on 11/13/14.
 */
public class DeckShoe {

    private ArrayList<Card> shoe;

    public DeckShoe(){
        this.shoe = new ArrayList<Card>();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 6; j++){
                shoe.add(new Card(i,"S"));
                shoe.add(new Card(i,"H"));
                shoe.add(new Card(i,"D"));
                shoe.add(new Card(i,"C"));
            }
        }
    }

    public void newShoe(){
        shoe.clear();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 6; j++){
                shoe.add(new Card(i,"S"));
                shoe.add(new Card(i,"H"));
                shoe.add(new Card(i,"D"));
                shoe.add(new Card(i,"C"));
            }
        }
    }

    public String dealCard(){
        int cardIndex = (int)(Math.random() * shoe.size());
        Card card = shoe.get(cardIndex);
        shoe.remove(cardIndex);
        return card.getCard();
    }

    //test function to see deck
    public void showDeck(){
        for(Card c : shoe){
            System.out.println(c.getCard());
        }
    }
}
