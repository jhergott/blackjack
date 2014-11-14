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
    private JPanel centerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
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
    private ImageIcon dealerFaceUpImage;
    private ImageIcon dealerFaceDownImage;
    private ImageIcon playerCard1Image;
    private ImageIcon playerCard2Image;
    private JLabel dealerCardDownLabel;
    private JLabel dealerCardUpLabel;
    private JLabel playerCard1Label;
    private JLabel playerCard2Label;
    private DeckShoe deckShoe;
    private Bankroll bankroll;
    private Card dealerFaceDown;
    private Card dealerFaceUp;
    private Card playerCard1;
    private Card playerCard2;
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
        setSize(700,500);
        this.stay = false;
        this.canBet = true;
    }

    public void createComponents(){
        deckShoe = new DeckShoe();
        bankroll = new Bankroll();

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.RED);
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.GREEN.darker().darker());
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.GREEN.darker());
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.GREEN.darker());
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.RED);
        dealerCardsPanel = new JPanel();
        playerCardsPanel = new JPanel();
        hitStayDoublePanel = new JPanel();
        hitStayDoublePanel.setBackground(Color.GREEN.darker());
        betPanel = new JPanel(new GridLayout(3,1));
        betPanel.setBackground(Color.GREEN.darker());
        playerPanel = new JPanel(new GridLayout(3,1));
        playerPanel.setBackground(Color.GREEN.darker());
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


        cardForImage = "cards/b2fv.png";//faceDown
        dealerFaceDownImage = new ImageIcon(cardForImage);
        dealerCardDownLabel = new JLabel(dealerFaceDownImage);
        dealerCardUpLabel = new JLabel(dealerFaceDownImage);
        playerCard1Label = new JLabel(dealerFaceDownImage);
        playerCard2Label = new JLabel(dealerFaceDownImage);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
        mainPanel.add(leftPanel,BorderLayout.LINE_START);
        mainPanel.add(rightPanel,BorderLayout.LINE_END);
        bottomPanel.add(hitStayDoublePanel, BorderLayout.CENTER);
        leftPanel.add(betPanel, BorderLayout.PAGE_END);
        rightPanel.add(playerPanel, BorderLayout.PAGE_END);
        hitStayDoublePanel.add(hit);
        hitStayDoublePanel.add(stand);
        hitStayDoublePanel.add(doubleDown);
        betPanel.add(betLabel);
        betPanel.add(betBox);
        betPanel.add(bet);
        playerPanel.add(bankrollLabel);
        playerPanel.add(handOutcome);
        playerPanel.add(reshuffling);
        centerPanel.add(dealerCardsPanel, BorderLayout.PAGE_START);
        centerPanel.add(playerCardsPanel, BorderLayout.PAGE_END);
        dealerCardsPanel.add(dealerCardDownLabel);
        dealerCardsPanel.add(dealerCardUpLabel);
        playerCardsPanel.add(playerCard1Label);
        playerCardsPanel.add(playerCard2Label);
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

        //deal Dealer's card face up
        dealerFaceUp = deckShoe.dealCard();
        dealerCard = dealerFaceUp.getCardValue();
        dealerScore += dealerCard;
        cardForImage = dealerFaceUp.getCardImage();
        dealerFaceUpImage = new ImageIcon(cardForImage);
        dealerCardUpLabel.setIcon(dealerFaceUpImage);
        System.out.println("C1: " + dealerCard);

        //deal first card to player
        playerCard1 = deckShoe.dealCard();
        playerCard = playerCard1.getCardValue();
        playerScore += playerCard;
        cardForImage = playerCard1.getCardImage();
        playerCard1Image = new ImageIcon(cardForImage);
        playerCard1Label.setIcon(playerCard1Image);
        System.out.println("P1: " + playerCard);

        //deal second card to player
        playerCard2 = deckShoe.dealCard();
        playerCard = playerCard2.getCardValue();
        playerScore += playerCard;
        cardForImage = playerCard2.getCardImage();
        playerCard2Image = new ImageIcon(cardForImage);
        playerCard2Label.setIcon(playerCard2Image);
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
