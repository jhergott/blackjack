package blackjack;

/**
 * Created by jakehergott on 11/13/14.
 */
public class Card {

    private int rank;
    private String suit;

    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getCard(){
        return rank + suit;
    }


}
