package blackjack;

import javax.swing.*;

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

    public Card getCard(){
        return this;
    }

    public int getCardValue(){
        //return the value of the card for blackjack
        return 0;//FIXXXXX
    }

    public String getCardImage(){
        String card = rank + suit;

        String imageIcon = "";
        if(suit.equals("C")) {
            switch (rank) {
                case 1: imageIcon = "cards/1.png";
                    break;
                case 2: imageIcon = "cards/49.png";
                    break;
                case 3: imageIcon = "cards/45.png";
                    break;
                case 4: imageIcon = "cards/41.png";
                    break;
                case 5: imageIcon = "cards/37.png";
                    break;
                case 6: imageIcon = "cards/33.png";
                    break;
                case 7: imageIcon = "cards/29.png";
                    break;
                case 8: imageIcon = "cards/25.png";
                    break;
                case 9: imageIcon = "cards/21.png";
                    break;
                case 10: imageIcon = "cards/17.png";
                    break;
                case 11: imageIcon = "cards/13.png";
                    break;
                case 12: imageIcon = "cards/9.png";
                    break;
                case 13: imageIcon = "cards/5.png";
                    break;
                default: imageIcon = "cards/b1fv.png";
                    break;

            }
        }else if(suit.equals("S")){
            switch (rank) {
                case 1: imageIcon = "cards/2.png";
                    break;
                case 2: imageIcon = "cards/50.png";
                    break;
                case 3: imageIcon = "cards/46.png";
                    break;
                case 4: imageIcon = "cards/42.png";
                    break;
                case 5: imageIcon = "cards/38.png";
                    break;
                case 6: imageIcon = "cards/34.png";
                    break;
                case 7: imageIcon = "cards/30.png";
                    break;
                case 8: imageIcon = "cards/26.png";
                    break;
                case 9: imageIcon = "cards/22.png";
                    break;
                case 10: imageIcon = "cards/18.png";
                    break;
                case 11: imageIcon = "cards/14.png";
                    break;
                case 12: imageIcon = "cards/10.png";
                    break;
                case 13: imageIcon = "cards/6.png";
                    break;
                default: imageIcon = "cards/b1fv.png";
                    break;
            }
        }else if(suit.equals("H")){
            switch (rank) {
                case 1: imageIcon = "cards/3.png";
                    break;
                case 2: imageIcon = "cards/51.png";
                    break;
                case 3: imageIcon = "cards/47.png";
                    break;
                case 4: imageIcon = "cards/43.png";
                    break;
                case 5: imageIcon = "cards/39.png";
                    break;
                case 6: imageIcon = "cards/35.png";
                    break;
                case 7: imageIcon = "cards/31.png";
                    break;
                case 8: imageIcon = "cards/27.png";
                    break;
                case 9: imageIcon = "cards/23.png";
                    break;
                case 10: imageIcon = "cards/19.png";
                    break;
                case 11: imageIcon = "cards/15.png";
                    break;
                case 12: imageIcon = "cards/11.png";
                    break;
                case 13: imageIcon = "cards/5.png";
                    break;
                default: imageIcon = "cards/b1fv.png";
                    break;
            }
        }else{//"Diamonds"
            switch (rank) {
                case 1: imageIcon = "cards/4.png";
                    break;
                case 2: imageIcon = "cards/52.png";
                    break;
                case 3: imageIcon = "cards/48.png";
                    break;
                case 4: imageIcon = "cards/44.png";
                    break;
                case 5: imageIcon = "cards/40.png";
                    break;
                case 6: imageIcon = "cards/36.png";
                    break;
                case 7: imageIcon = "cards/32.png";
                    break;
                case 8: imageIcon = "cards/28.png";
                    break;
                case 9: imageIcon = "cards/24.png";
                    break;
                case 10: imageIcon = "cards/20.png";
                    break;
                case 11: imageIcon = "cards/16.png";
                    break;
                case 12: imageIcon = "cards/12.png";
                    break;
                case 13: imageIcon = "cards/6.png";
                    break;
                default: imageIcon = "cards/b1fv.png";
                    break;
            }
        }
        return imageIcon;
    }



}
