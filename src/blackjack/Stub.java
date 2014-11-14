package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stub extends JFrame{

    private JPanel mainPanel;
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JTextField betBox;
    private JButton hit;
    private JButton stand;
    private JButton doubleDown;
    private JButton bet;
    private JButton cashOut;
    private String cardForImage;
    private ImageIcon cardImage;
    private JLabel cardLabel;
    private DeckShoe deckShoe;
    private Bankroll bankroll;
    private double betAmount;
    private int playerScore;
    private int dealerScore;
    private int playerCard;
    private int dealerCard;
    private boolean stay;
    private boolean playerBusted;
    private boolean dealerBusted;

    public Stub(){
        createComponents();
        setSize(500,500);
        this.stay = false;
    }

    public void createComponents(){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN.darker().darker());
        dealerPanel = new JPanel();
        playerPanel = new JPanel();

        hit = new JButton("HIT");
        ActionListener hitListener = new HitButton();
        hit.addActionListener(hitListener);

        stand = new JButton("STAND");
        ActionListener standListener = new StandButton();
        stand.addActionListener(standListener);

        doubleDown = new JButton("DOUBLE DOWN");
        ActionListener doubleDownListener = new DoubleDownButton();
        doubleDown.addActionListener(doubleDownListener);

        betBox = new JTextField(6);
        bet = new JButton("BET");
        ActionListener betListener = new BetButton();
        bet.addActionListener(betListener);
        betBox.addActionListener(betListener);

        cashOut = new JButton("CASH OUT");

        deckShoe = new DeckShoe();
        bankroll = new Bankroll();

        cardForImage = deckShoe.dealCard().getCardImage();
        cardImage = new ImageIcon(cardForImage);
        cardLabel = new JLabel(cardImage);

        mainPanel.add(dealerPanel);
        mainPanel.add(playerPanel);
        dealerPanel.add(hit);
        dealerPanel.add(stand);
        dealerPanel.add(doubleDown);
        playerPanel.add(betBox);
        playerPanel.add(bet);
        playerPanel.add(cashOut);
        playerPanel.add(cardLabel);
        add(mainPanel);

    }

    class BetButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            betAmount = Double.parseDouble(betBox.getText());
            bankroll.bet(betAmount);
            System.out.println(betBox.getText());
            newHand();
        }
    }

    public void newHand(){
        playerBusted = false;
        dealerBusted = false;
        stay = false;
        playerScore = 0;
        dealerScore = 0;

        dealerCard = deckShoe.dealCard().getCardValue();
        dealerScore += dealerCard;
        System.out.println("C1: " + dealerCard);

        playerCard = deckShoe.dealCard().getCardValue();
        playerScore += playerCard;
        System.out.println("P1: " + playerCard);
        playerCard = deckShoe.dealCard().getCardValue();
        playerScore += playerCard;
        System.out.println("P2: " + playerCard);
    }

    class HitButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            playerCard = deckShoe.dealCard().getCardValue();
            playerScore += playerCard;
            System.out.println("Hit: " + playerCard);
            System.out.println("Player: " + playerScore);
            if(playerScore > 21){
                System.out.println("Busted");
                playerBusted = true;
                stay = true;
                bankroll.loss();
                endHand();
            }else {
                endPlayerTurn();
            }
        }
    }

    class StandButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            stay = true;
            endPlayerTurn();
        }
    }

    class DoubleDownButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            bankroll.bet(betAmount * 2);
            System.out.println(betAmount*2);
            playerCard = deckShoe.dealCard().getCardValue();
            playerScore += playerCard;
            System.out.println("Double Down: " + playerCard);
            System.out.println("Player: " + playerScore);
            stay = true;
            endPlayerTurn();
        }
    }

    public void dealerTurn(){
        while (dealerScore < 17) {
            dealerCard = deckShoe.dealCard().getCardValue();
            dealerScore += dealerCard;
            System.out.println("card: " + dealerCard);
            System.out.println("Dealer: " + dealerScore);
            if (dealerScore > 21) {
                System.out.println("Dealer Busted");
                dealerBusted = true;
                bankroll.win();
            }
        }
        endHand();
    }

    public void winner(){
        if (dealerScore == playerScore) {
            System.out.println("Push");
        } else if (playerScore > dealerScore) {
            bankroll.win();
            System.out.println("Player WINS");
        } else {
            bankroll.loss();
            System.out.println("Player LOSS");
        }
        System.out.println("BANKROLL: " + bankroll.getBankroll());
    }


    public void endHand(){
        if(playerBusted || dealerBusted){
            System.out.println(bankroll.getBankroll());
        }else {
            winner();
        }
    }

    public void endPlayerTurn(){
        if(stay){
            dealerTurn();
        }
    }

}
