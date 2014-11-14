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
    private JPanel hitStayDoublePanel;
    private JPanel betPanel;
    private JPanel playerPanel;
    private JPanel dealerCardsPanel;
    private JPanel playerCardsPanel;
    private JTextField betBox;
    private JButton hit;
    private JButton stand;
    private JButton doubleDown;
    private JLabel betLabel;
    private JLabel bankrollLabel;
    private JLabel reshuffling;
    private JLabel handOutcome;
    private JButton bet;
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
    private boolean canDoubleDown;
    private boolean canBet;

    public Stub(){
        createComponents();
        setSize(500,500);
        this.stay = false;
        this.canBet = true;
    }

    public void createComponents(){
        deckShoe = new DeckShoe();
        bankroll = new Bankroll();

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN.darker().darker());
        hitStayDoublePanel = new JPanel();
        betPanel = new JPanel();
        playerPanel = new JPanel();
        dealerCardsPanel = new JPanel();
        playerCardsPanel = new JPanel();


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

        betLabel = new JLabel("Wager:");
        bankrollLabel = new JLabel("Bankroll: $" + bankroll.getBankroll());
        reshuffling = new JLabel("        ");
        handOutcome = new JLabel("    ");


        cardForImage = deckShoe.dealCard().getCardImage();
        cardImage = new ImageIcon(cardForImage);
        cardLabel = new JLabel(cardImage);

        //mainPanel.add(dealerPanel);
        //mainPanel.add(playerPanel);
        hitStayDoublePanel.add(hit);
        hitStayDoublePanel.add(stand);
        hitStayDoublePanel.add(doubleDown);
        betPanel.add(betLabel);
        betPanel.add(betBox);
        betPanel.add(bet);
        playerPanel.add(handOutcome);
        playerPanel.add(bankrollLabel);
        playerPanel.add(reshuffling);
        mainPanel.add(cardLabel);
        add(mainPanel);

    }

    class BetButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canBet) {
                betAmount = Double.parseDouble(betBox.getText());
                bankroll.bet(betAmount);
                System.out.println(betBox.getText());
                newHand();
            }
            canBet = false;
        }
    }

    public void newHand(){
        if(deckShoe.getShoe().size() < 50){
            deckShoe.newShoe();
            reshuffling.setText("NEW SHOE");
        }
        handOutcome.setText("    ");
        canDoubleDown = true;
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
                handOutcome.setText("LOSS");
                endHand();
            }else {
                canDoubleDown = false;
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
            if(canDoubleDown) {
                bankroll.bet(betAmount * 2);
                System.out.println(betAmount * 2);
                playerCard = deckShoe.dealCard().getCardValue();
                playerScore += playerCard;
                System.out.println("Double Down: " + playerCard);
                System.out.println("Player: " + playerScore);
                stay = true;
                endPlayerTurn();
            }
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
                handOutcome.setText("WIN ");
            }
        }
        endHand();
    }

    public void winner(){
        if (dealerScore == playerScore) {
            handOutcome.setText("PUSH");
        } else if (playerScore > dealerScore) {
            bankroll.win();
            handOutcome.setText("WIN ");
        } else {
            bankroll.loss();
            handOutcome.setText("LOSS");
        }
        bankrollLabel.setText("Bankroll: $" + bankroll.getBankroll());
    }


    public void endHand(){
        if(playerBusted || dealerBusted){
            bankrollLabel.setText("Bankroll: $" + bankroll.getBankroll());
        }else {
            winner();
        }
        canBet = true;
        reshuffling.setText("");
    }

    public void endPlayerTurn(){
        if(stay){
            dealerTurn();
        }
    }

}
