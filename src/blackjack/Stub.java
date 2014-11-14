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
    private ImageIcon dealerCard3Image;
    private ImageIcon dealerCard4Image;
    private ImageIcon dealerCard5Image;
    private ImageIcon dealerCard6Image;
    private ImageIcon playerCard1Image;
    private ImageIcon playerCard2Image;
    private ImageIcon playerCard3Image;
    private ImageIcon playerCard4Image;
    private ImageIcon playerCard5Image;
    private ImageIcon playerCard6Image;
    private JLabel dealerCardDownLabel;
    private JLabel dealerCardUpLabel;
    private JLabel dealerCard3Label;
    private JLabel dealerCard4Label;
    private JLabel dealerCard5Label;
    private JLabel dealerCard6Label;
    private JLabel playerCard1Label;
    private JLabel playerCard2Label;
    private JLabel playerCard3Label;
    private JLabel playerCard4Label;
    private JLabel playerCard5Label;
    private JLabel playerCard6Label;
    private DeckShoe deckShoe;
    private Bankroll bankroll;
    private Card dealerFaceDown;
    private Card dealerFaceUp;
    private Card dealerCard3;
    private Card dealerCard4;
    private Card dealerCard5;
    private Card dealerCard6;
    private Card playerCard1;
    private Card playerCard2;
    private Card playerCard3;
    private Card playerCard4;
    private Card playerCard5;
    private Card playerCard6;
    private double betAmount;
    private int playerScore;
    private int dealerScore;
    private int playerCard;
    private int dealerCard;
    private int nHits; //counts number of hits
    private int nDealerHits; //counts number of dealer hits
    private boolean stay;
    private boolean playerBusted;
    private boolean dealerBusted;
    private boolean canDoubleDown;
    private boolean canHit;
    private boolean canStay;
    private boolean canBet;

    public Stub(){
        createComponents();
        setSize(700,500);
        this.stay = false;
        this.canBet = true;
        this.canDoubleDown = false;
        this.canHit = false;
        this.canStay = false;
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
        dealerCardsPanel.setBackground(Color.GREEN.darker().darker());
        playerCardsPanel = new JPanel();
        playerCardsPanel.setBackground(Color.GREEN.darker().darker());

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
        playerCard3Label = new JLabel();
        playerCard4Label = new JLabel();
        playerCard5Label = new JLabel();
        playerCard6Label = new JLabel();
        dealerCard3Label = new JLabel();
        dealerCard4Label = new JLabel();
        dealerCard5Label = new JLabel();
        dealerCard6Label = new JLabel();

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
        dealerCardsPanel.add(dealerCard3Label);
        dealerCardsPanel.add(dealerCard4Label);
        dealerCardsPanel.add(dealerCard5Label);
        dealerCardsPanel.add(dealerCard6Label);
        playerCardsPanel.add(playerCard1Label);
        playerCardsPanel.add(playerCard2Label);
        playerCardsPanel.add(playerCard3Label);
        playerCardsPanel.add(playerCard4Label);
        playerCardsPanel.add(playerCard5Label);
        playerCardsPanel.add(playerCard6Label);
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
        nHits = 0;
        playerCard3Label.setIcon(null);
        playerCard4Label.setIcon(null);
        playerCard5Label.setIcon(null);
        playerCard6Label.setIcon(null);
        cardForImage = "cards/b2fv.png";//faceDown
        dealerFaceDownImage = new ImageIcon(cardForImage);
        dealerCardDownLabel.setIcon(dealerFaceDownImage);
        dealerCard3Label.setIcon(null);
        dealerCard4Label.setIcon(null);
        dealerCard5Label.setIcon(null);
        dealerCard6Label.setIcon(null);
        canHit = true;
        canStay = true;
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
            if(canHit) {
                nHits++;
                if (nHits == 1) {
                    playerCard3 = deckShoe.dealCard();
                    playerCard = playerCard3.getCardValue();
                    playerScore += playerCard;
                    cardForImage = playerCard3.getCardImage();
                    playerCard3Image = new ImageIcon(cardForImage);
                    playerCard3Label.setIcon(playerCard3Image);
                    System.out.println("Hit: " + playerCard);
                    System.out.println("Player: " + playerScore);
                } else if (nHits == 2) {
                    playerCard4 = deckShoe.dealCard();
                    playerCard = playerCard4.getCardValue();
                    playerScore += playerCard;
                    cardForImage = playerCard4.getCardImage();
                    playerCard4Image = new ImageIcon(cardForImage);
                    playerCard4Label.setIcon(playerCard4Image);
                    System.out.println("Hit: " + playerCard);
                    System.out.println("Player: " + playerScore);
                } else if (nHits == 3) {
                    playerCard5 = deckShoe.dealCard();
                    playerCard = playerCard5.getCardValue();
                    playerScore += playerCard;
                    cardForImage = playerCard5.getCardImage();
                    playerCard5Image = new ImageIcon(cardForImage);
                    playerCard5Label.setIcon(playerCard5Image);
                    System.out.println("Hit: " + playerCard);
                    System.out.println("Player: " + playerScore);
                } else {//4
                    playerCard6 = deckShoe.dealCard();
                    playerCard = playerCard6.getCardValue();
                    playerScore += playerCard;
                    cardForImage = playerCard6.getCardImage();
                    playerCard6Image = new ImageIcon(cardForImage);
                    playerCard6Label.setIcon(playerCard6Image);
                    System.out.println("Hit: " + playerCard);
                    System.out.println("Player: " + playerScore);
                }

                if (playerScore > 21) {
                    System.out.println("Busted");
                    playerBusted = true;
                    stay = true;
                    canStay = false;
                    bankroll.loss();
                    handOutcome.setText("LOSS");
                    endHand();
                } else {
                    canDoubleDown = false;
                    endPlayerTurn();
                }
            }
        }
    }

    class StandButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canStay) {
                stay = true;
                endPlayerTurn();
            }
        }
    }

    class DoubleDownButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canDoubleDown) {
                bankroll.bet(betAmount * 2);
                System.out.println(betAmount * 2);

                //deal double down card to player
                playerCard3 = deckShoe.dealCard();
                playerCard = playerCard3.getCardValue();
                playerScore += playerCard;
                cardForImage = playerCard3.getCardImage();
                playerCard3Image = new ImageIcon(cardForImage);
                playerCard3Label.setIcon(playerCard3Image);
                System.out.println("Double Down: " + playerCard);
                System.out.println("Player: " + playerScore);
                stay = true;
                endPlayerTurn();
            }
        }
    }

    public void dealerTurn(){
        nDealerHits = 0;
        while (dealerScore < 17) {
            nDealerHits++;
            if(nDealerHits == 1){
                dealerFaceDown = deckShoe.dealCard();
                dealerCard = dealerFaceDown.getCardValue();
                dealerScore += dealerCard;
                cardForImage = dealerFaceDown.getCardImage();
                dealerFaceDownImage = new ImageIcon(cardForImage);
                dealerCardDownLabel.setIcon(dealerFaceDownImage);
                System.out.println("Dealer: " + dealerCard);
                System.out.println("Dealer score: " + dealerScore);
            }else if(nDealerHits == 2){
                dealerCard3 = deckShoe.dealCard();
                dealerCard = dealerCard3.getCardValue();
                dealerScore += dealerCard;
                cardForImage = dealerCard3.getCardImage();
                dealerCard3Image = new ImageIcon(cardForImage);
                dealerCard3Label.setIcon(dealerCard3Image);
                System.out.println("Dealer: " + dealerCard);
                System.out.println("Dealer score: " + dealerScore);
            }else if(nDealerHits == 3){
                dealerCard4 = deckShoe.dealCard();
                dealerCard = dealerCard4.getCardValue();
                dealerScore += dealerCard;
                cardForImage = dealerCard4.getCardImage();
                dealerCard4Image = new ImageIcon(cardForImage);
                dealerCard4Label.setIcon(dealerCard4Image);
                System.out.println("Dealer: " + dealerCard);
                System.out.println("Dealer score: " + dealerScore);
            }else if(nDealerHits == 4){
                dealerCard5 = deckShoe.dealCard();
                dealerCard = dealerCard5.getCardValue();
                dealerScore += dealerCard;
                cardForImage = dealerCard5.getCardImage();
                dealerCard5Image = new ImageIcon(cardForImage);
                dealerCard5Label.setIcon(dealerCard5Image);
                System.out.println("Dealer: " + dealerCard);
                System.out.println("Dealer score: " + dealerScore);
            }else{//5
                dealerCard6 = deckShoe.dealCard();
                dealerCard = dealerCard6.getCardValue();
                dealerScore += dealerCard;
                cardForImage = dealerCard6.getCardImage();
                dealerCard6Image = new ImageIcon(cardForImage);
                dealerCard6Label.setIcon(dealerCard6Image);
                System.out.println("Dealer: " + dealerCard);
                System.out.println("Dealer score: " + dealerScore);
            }


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
        canDoubleDown = false;
        canHit = false;
        reshuffling.setText("");
    }

    public void endPlayerTurn(){
        if(stay){
            dealerTurn();
        }
    }

}
