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

    public String getCard(){
        return rank + suit;
    }

    public Icon getCardImage(){
        String card = rank + suit;

        ImageIcon imageIcon = new ImageIcon("cards/b1fv.png");
        if(suit.equals("C")) {
            switch (rank) {
                case 1: imageIcon = new ImageIcon("cards/1.png");
                    break;
                case 2: imageIcon = new ImageIcon("cards/49.png");
                    break;
                case 3: imageIcon = new ImageIcon("cards/45.png");
                    break;
                case 4: imageIcon = new ImageIcon("cards/41.png");
                    break;
                case 5: imageIcon = new ImageIcon("cards/37.png");
                    break;
                case 6: imageIcon = new ImageIcon("cards/33.png");
                    break;
                case 7: imageIcon = new ImageIcon("cards/29.png");
                    break;
                case 8: imageIcon = new ImageIcon("cards/25.png");
                    break;
                case 9: imageIcon = new ImageIcon("cards/21.png");
                    break;
                case 10: imageIcon = new ImageIcon("cards/17.png");
                    break;
                case 11: imageIcon = new ImageIcon("cards/13.png");
                    break;
                case 12: imageIcon = new ImageIcon("cards/9.png");
                    break;
                case 13: imageIcon = new ImageIcon("cards/5.png");
                    break;
                default: imageIcon = new ImageIcon("cards/b1fv.png");
                    break;

            }
        }else if(suit.equals("S")){
            switch (rank) {
                case 1: imageIcon = new ImageIcon("cards/2.png");
                    break;
                case 2: imageIcon = new ImageIcon("cards/50.png");
                    break;
                case 3: imageIcon = new ImageIcon("cards/46.png");
                    break;
                case 4: imageIcon = new ImageIcon("cards/42.png");
                    break;
                case 5: imageIcon = new ImageIcon("cards/38.png");
                    break;
                case 6: imageIcon = new ImageIcon("cards/34.png");
                    break;
                case 7: imageIcon = new ImageIcon("cards/30.png");
                    break;
                case 8: imageIcon = new ImageIcon("cards/26.png");
                    break;
                case 9: imageIcon = new ImageIcon("cards/22.png");
                    break;
                case 10: imageIcon = new ImageIcon("cards/18.png");
                    break;
                case 11: imageIcon = new ImageIcon("cards/14.png");
                    break;
                case 12: imageIcon = new ImageIcon("cards/10.png");
                    break;
                case 13: imageIcon = new ImageIcon("cards/6.png");
                    break;
                default: imageIcon = new ImageIcon("cards/b1fv.png");
                    break;
            }
        }else if(suit.equals("H")){
            switch (rank) {
                case 1: imageIcon = new ImageIcon("cards/3.png");
                    break;
                case 2: imageIcon = new ImageIcon("cards/51.png");
                    break;
                case 3: imageIcon = new ImageIcon("cards/47.png");
                    break;
                case 4: imageIcon = new ImageIcon("cards/43.png");
                    break;
                case 5: imageIcon = new ImageIcon("cards/39.png");
                    break;
                case 6: imageIcon = new ImageIcon("cards/35.png");
                    break;
                case 7: imageIcon = new ImageIcon("cards/31.png");
                    break;
                case 8: imageIcon = new ImageIcon("cards/27.png");
                    break;
                case 9: imageIcon = new ImageIcon("cards/23.png");
                    break;
                case 10: imageIcon = new ImageIcon("cards/19.png");
                    break;
                case 11: imageIcon = new ImageIcon("cards/15.png");
                    break;
                case 12: imageIcon = new ImageIcon("cards/11.png");
                    break;
                case 13: imageIcon = new ImageIcon("cards/5.png");
                    break;
                default: imageIcon = new ImageIcon("cards/b1fv.png");
                    break;
            }
        }else{//"Diamonds"
            switch (rank) {
                case 1: imageIcon = new ImageIcon("cards/4.png");
                    break;
                case 2: imageIcon = new ImageIcon("cards/52.png");
                    break;
                case 3: imageIcon = new ImageIcon("cards/48.png");
                    break;
                case 4: imageIcon = new ImageIcon("cards/44.png");
                    break;
                case 5: imageIcon = new ImageIcon("cards/40.png");
                    break;
                case 6: imageIcon = new ImageIcon("cards/36.png");
                    break;
                case 7: imageIcon = new ImageIcon("cards/32.png");
                    break;
                case 8: imageIcon = new ImageIcon("cards/28.png");
                    break;
                case 9: imageIcon = new ImageIcon("cards/24.png");
                    break;
                case 10: imageIcon = new ImageIcon("cards/20.png");
                    break;
                case 11: imageIcon = new ImageIcon("cards/16.png");
                    break;
                case 12: imageIcon = new ImageIcon("cards/12.png");
                    break;
                case 13: imageIcon = new ImageIcon("cards/6.png");
                    break;
                default: imageIcon = new ImageIcon("cards/b1fv.png");
                    break;
            }
        }
        return imageIcon;
    }



}
