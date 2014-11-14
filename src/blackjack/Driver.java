package blackjack;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by jakehergott on 11/13/14.
 */
public class Driver {

    public static void main(String[] args) {

        //for Stub
        /*JFrame frame = new Stub();
        frame.setTitle("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);*/

        Scanner in = new Scanner(System.in);

        DeckShoe deckShoe = new DeckShoe();
        Bankroll bankroll = new Bankroll();

        int playerHand = 0;
        int cpuHand = 0;

        int dealerCard = deckShoe.dealCard().getCardValue();
        cpuHand += dealerCard;

        int playerCard1 = deckShoe.dealCard().getCardValue();
        int playerCard2 = deckShoe.dealCard().getCardValue();
        playerHand += playerCard1 + playerCard2;

        System.out.println(bankroll.getBankroll());
        System.out.println("Place your bet:");
        double bet = in.nextDouble();
        bankroll.bet(bet);
        System.out.println(bet);
        System.out.println("Dealer: " + cpuHand);
        System.out.println("Card1: " + playerCard1);
        System.out.println("Card2: " + playerCard2);
        System.out.println("Player: " + playerHand);

        boolean stay = false;
        boolean dealerBusted = false;
        boolean playerBusted = false;
        int playerHits = 0;
        System.out.println("Hit or Stay or Double?");
        String decision = in.next();
        if(decision.equals("d")) {
            bankroll.bet(bet * 2);
            playerHits = deckShoe.dealCard().getCardValue();
            playerHand += playerHits;
            System.out.println("Double Down: " + playerHits);
            System.out.println("Player: " + playerHand);
            stay = true;
        }
        while(!stay){
            System.out.println("Hit or Stay?");
            decision = in.next();
            if(decision.equals("h")){
                playerHits = deckShoe.dealCard().getCardValue();
                playerHand += playerHits;
                System.out.println("Hit: " + playerHits);
                System.out.println("Player: " + playerHand);
            }else {
                stay = true;
            }
            if(playerHand > 21){
                System.out.println("Busted");
                playerBusted = true;
                stay = true;
                bankroll.loss();
            }
        }

        if(!playerBusted) {
            int dealerHits = 0;
            while (cpuHand < 17) {
                dealerHits = deckShoe.dealCard().getCardValue();
                cpuHand += dealerHits;
                System.out.println(dealerHits);
                System.out.println("Dealer: " + cpuHand);
                if (cpuHand > 21) {
                    System.out.println("Dealer Busted");
                    dealerBusted = true;
                    bankroll.win();
                }
            }
        }

        if(!playerBusted && !dealerBusted) {
            if (cpuHand == playerHand) {
                System.out.println("Push");
            } else if (playerHand > cpuHand) {
                bankroll.win();
                System.out.println("Player WINS");
            } else {
                bankroll.loss();
                System.out.println("Player LOSS");
            }
        }

        System.out.println(bankroll.getBankroll());


    }
}
