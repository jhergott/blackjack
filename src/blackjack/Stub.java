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
    private JPanel middlePanel;
    private JPanel middleCenterPanel;
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
    private JLabel dealerScoreLabel;
    private JLabel playerScoreLabel;
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
    private int nPlayerAces; //aces in players hand
    private int nDealerAces; //aces in dealers hand
    private boolean stay;
    private boolean playerBusted;
    private boolean dealerBusted;
    private boolean canDoubleDown;
    private boolean canHit;
    private boolean canStay;
    private boolean canBet;
    private boolean blackJack;

    private JButton reload;

    public Stub(){
        createComponents();
        setSize(700,500);
        this.stay = false;
        this.canBet = true;
        this.canDoubleDown = false;
        this.canHit = false;
        this.canStay = false;
        this.blackJack = false;
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
        middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(Color.GREEN.darker().darker());
        dealerCardsPanel = new JPanel();
        playerCardsPanel = new JPanel();
        hitStayDoublePanel = new JPanel();
        hitStayDoublePanel.setBackground(Color.GREEN.darker());
        betPanel = new JPanel(new GridLayout(10,1));
        betPanel.setBackground(Color.GREEN.darker());
        playerPanel = new JPanel(new GridLayout(2,1));
        playerPanel.setBackground(Color.GREEN.darker().darker());
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
        bet = new JButton("Bet");
        ActionListener betListener = new BetButton();
        bet.addActionListener(betListener);
        betBox.addActionListener(betListener);

        betLabel = new JLabel("Wager:");
        bankrollLabel = new JLabel("Bankroll: $" + bankroll.getBankroll());
        reshuffling = new JLabel("        ");
        handOutcome = new JLabel("    ");

        dealerScoreLabel = new JLabel("Dealer Score: " + dealerScore);
        playerScoreLabel = new JLabel("Player Score: " + playerScore);

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

        reload = new JButton("Reload");
        ActionListener reloadListener = new ReloadButton();
        reload.addActionListener(reloadListener);


        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
        mainPanel.add(leftPanel,BorderLayout.LINE_START);
        //mainPanel.add(rightPanel,BorderLayout.LINE_END);
        //bottomPanel.add(hitStayDoublePanel, BorderLayout.CENTER);
        leftPanel.add(betPanel, BorderLayout.PAGE_END);
        //hitStayDoublePanel.add(hit);
        //hitStayDoublePanel.add(stand);
        //hitStayDoublePanel.add(doubleDown);
        betPanel.add(reshuffling);
        betPanel.add(handOutcome);
        betPanel.add(bankrollLabel);
        betPanel.add(betLabel);
        betPanel.add(betBox);
        betPanel.add(bet);
        betPanel.add(reload);
        betPanel.add(hit);
        betPanel.add(stand);
        betPanel.add(doubleDown);
        playerPanel.add(dealerScoreLabel);
        playerPanel.add(playerScoreLabel);
        centerPanel.add(dealerCardsPanel, BorderLayout.PAGE_START);
        centerPanel.add(middlePanel, BorderLayout.CENTER);
        middlePanel.add(playerPanel, BorderLayout.LINE_START);
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

    class ReloadButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canBet) {
                if (bankroll.getBankroll() <= 1000) {
                    bankroll.setBankroll(1000);
                    bankrollLabel.setText("Bankroll: $" + bankroll.getBankroll());
                }
            }
        }
    }

    class BetButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canBet) {
                betAmount = Double.parseDouble(betBox.getText());
                if(betAmount <= bankroll.getBankroll() && betAmount > 0) {
                    bankroll.bet(betAmount);
                    newHand();
                }
            }
            if(betAmount <= bankroll.getBankroll() && betAmount > 0) {
                canBet = false;
            }
        }
    }

    public void newHand(){
        if(deckShoe.getShoe().size() < 150){
            deckShoe.newShoe();
            reshuffling.setText("NEW SHOE");
        }
        handOutcome.setText("    ");
        nHits = 0;
        nDealerAces = 0;
        nPlayerAces = 0;
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
        blackJack = false;
        playerScore = 0;
        dealerScore = 0;

        //deal Dealer's card face up
        dealerFaceUp = deckShoe.dealCard();
        dealerCard = dealerFaceUp.getCardValue();
        if(dealerCard == 11){
            nDealerAces++;
        }
        dealerScore += dealerCard;
        cardForImage = dealerFaceUp.getCardImage();
        dealerFaceUpImage = new ImageIcon(cardForImage);
        dealerCardUpLabel.setIcon(dealerFaceUpImage);

        //deal first card to player
        playerCard1 = deckShoe.dealCard();
        playerCard = playerCard1.getCardValue();
        playerScore += playerCard;
        cardForImage = playerCard1.getCardImage();
        playerCard1Image = new ImageIcon(cardForImage);
        playerCard1Label.setIcon(playerCard1Image);
        if(playerCard == 11){
            nPlayerAces++;
        }

        //deal second card to player
        playerCard2 = deckShoe.dealCard();
        playerCard = playerCard2.getCardValue();
        if(playerCard == 11){
            nPlayerAces++;
        }
        if(nPlayerAces == 2){
            playerScore = 12;
            nPlayerAces--;
        }else {
            playerScore += playerCard;
        }
        cardForImage = playerCard2.getCardImage();
        playerCard2Image = new ImageIcon(cardForImage);
        playerCard2Label.setIcon(playerCard2Image);

        dealerScoreLabel.setText("Dealer Score: " + dealerScore);
        playerScoreLabel.setText("Player Score: " + playerScore);

        if(playerScore == 21){
            betAmount = betAmount * 1.5;
            bankroll.bet(betAmount);
            blackJack = true;
            canBet = true;
            canDoubleDown = false;
            canHit = false;
        }
    }

    class HitButton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(canHit) {
                nHits++;
                if (nHits == 1) {
                    playerCard3 = deckShoe.dealCard();
                    playerCard = playerCard3.getCardValue();
                    if(playerCard == 11){
                        nPlayerAces++;
                    }
                    playerScore += playerCard;
                    if(playerScore > 21 && nPlayerAces > 0){
                        playerScore = playerScore - 10;
                        nPlayerAces--;
                    }
                    cardForImage = playerCard3.getCardImage();
                    playerCard3Image = new ImageIcon(cardForImage);
                    playerCard3Label.setIcon(playerCard3Image);
                    playerScoreLabel.setText("Player Score: " + playerScore);
                } else if (nHits == 2) {
                    playerCard4 = deckShoe.dealCard();
                    playerCard = playerCard4.getCardValue();
                    if(playerCard == 11){
                        nPlayerAces++;
                    }
                    playerScore += playerCard;
                    if(playerScore > 21 && nPlayerAces > 0){
                        playerScore = playerScore - 10;
                        nPlayerAces--;
                    }
                    cardForImage = playerCard4.getCardImage();
                    playerCard4Image = new ImageIcon(cardForImage);
                    playerCard4Label.setIcon(playerCard4Image);
                    playerScoreLabel.setText("Player Score: " + playerScore);
                } else if (nHits == 3) {
                    playerCard5 = deckShoe.dealCard();
                    playerCard = playerCard5.getCardValue();
                    if(playerCard == 11){
                        nPlayerAces++;
                    }
                    playerScore += playerCard;
                    if(playerScore > 21 && nPlayerAces > 0){
                        playerScore = playerScore - 10;
                        nPlayerAces--;
                    }
                    cardForImage = playerCard5.getCardImage();
                    playerCard5Image = new ImageIcon(cardForImage);
                    playerCard5Label.setIcon(playerCard5Image);
                    playerScoreLabel.setText("Player Score: " + playerScore);
                } else {//4
                    playerCard6 = deckShoe.dealCard();
                    playerCard = playerCard6.getCardValue();
                    if(playerCard == 11){
                        nPlayerAces++;
                    }
                    playerScore += playerCard;
                    if(playerScore > 21 && nPlayerAces > 0){
                        playerScore = playerScore - 10;
                        nPlayerAces--;
                    }
                    cardForImage = playerCard6.getCardImage();
                    playerCard6Image = new ImageIcon(cardForImage);
                    playerCard6Label.setIcon(playerCard6Image);
                    playerScoreLabel.setText("Player Score: " + playerScore);
                }

                if (playerScore > 21) {
                    playerBusted = true;
                    stay = true;
                    canStay = false;
                    bankroll.loss();
                    handOutcome.setText("LOST $" + betAmount);
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
                betAmount = Math.min(betAmount * 2,bankroll.getBankroll());//double for less if you cant double
                bankroll.bet(betAmount);

                //deal double down card to player
                playerCard3 = deckShoe.dealCard();
                playerCard = playerCard3.getCardValue();
                if(playerCard == 11){
                    nPlayerAces++;
                }
                playerScore += playerCard;
                if(playerScore > 21 && nPlayerAces > 0){
                    playerScore = playerScore - 10;
                    nPlayerAces--;
                }
                cardForImage = playerCard3.getCardImage();
                playerCard3Image = new ImageIcon(cardForImage);
                playerCard3Label.setIcon(playerCard3Image);
                playerScoreLabel.setText("Player Score: " + playerScore);

                if (playerScore > 21) {
                    playerBusted = true;
                    stay = true;
                    canStay = false;
                    bankroll.loss();
                    handOutcome.setText("LOST $" + betAmount);
                    endHand();
                } else {
                    stay = true;
                    canStay = false;
                    canDoubleDown = false;
                    endPlayerTurn();
                }
            }
        }
    }

    public void dealerTurn(){
        nDealerHits = 0;
        if(!blackJack) {
            while (dealerScore < 17 || (dealerScore <= 17 && nDealerAces > 0)) {
                nDealerHits++;
                if (nDealerHits == 1) {
                    dealerFaceDown = deckShoe.dealCard();
                    dealerCard = dealerFaceDown.getCardValue();
                    if (dealerCard == 11) {
                        nDealerAces++;
                    }
                    dealerScore += dealerCard;
                    if (dealerScore > 21 && nDealerAces > 0) {
                        dealerScore = dealerScore - 10;
                        nDealerAces--;
                    }
                    cardForImage = dealerFaceDown.getCardImage();
                    dealerFaceDownImage = new ImageIcon(cardForImage);
                    dealerCardDownLabel.setIcon(dealerFaceDownImage);
                    dealerScoreLabel.setText("Dealer Score: " + dealerScore);
                } else if (nDealerHits == 2) {
                    dealerCard3 = deckShoe.dealCard();
                    dealerCard = dealerCard3.getCardValue();
                    if (dealerCard == 11) {
                        nDealerAces++;
                    }
                    dealerScore += dealerCard;
                    if (dealerScore > 21 && nDealerAces > 0) {
                        dealerScore = dealerScore - 10;
                        nDealerAces--;
                    }
                    cardForImage = dealerCard3.getCardImage();
                    dealerCard3Image = new ImageIcon(cardForImage);
                    dealerCard3Label.setIcon(dealerCard3Image);
                    dealerScoreLabel.setText("Dealer Score: " + dealerScore);
                } else if (nDealerHits == 3) {
                    dealerCard4 = deckShoe.dealCard();
                    dealerCard = dealerCard4.getCardValue();
                    if (dealerCard == 11) {
                        nDealerAces++;
                    }
                    dealerScore += dealerCard;
                    if (dealerScore > 21 && nDealerAces > 0) {
                        dealerScore = dealerScore - 10;
                        nDealerAces--;
                    }
                    cardForImage = dealerCard4.getCardImage();
                    dealerCard4Image = new ImageIcon(cardForImage);
                    dealerCard4Label.setIcon(dealerCard4Image);
                    dealerScoreLabel.setText("Dealer Score: " + dealerScore);
                } else if (nDealerHits == 4) {
                    dealerCard5 = deckShoe.dealCard();
                    dealerCard = dealerCard5.getCardValue();
                    if (dealerCard == 11) {
                        nDealerAces++;
                    }
                    dealerScore += dealerCard;
                    if (dealerScore > 21 && nDealerAces > 0) {
                        dealerScore = dealerScore - 10;
                        nDealerAces--;
                    }
                    cardForImage = dealerCard5.getCardImage();
                    dealerCard5Image = new ImageIcon(cardForImage);
                    dealerCard5Label.setIcon(dealerCard5Image);
                    dealerScoreLabel.setText("Dealer Score: " + dealerScore);
                } else {//5
                    dealerCard6 = deckShoe.dealCard();
                    dealerCard = dealerCard6.getCardValue();
                    if (dealerCard == 11) {
                        nDealerAces++;
                    }
                    dealerScore += dealerCard;
                    if (dealerScore > 21 && nDealerAces > 0) {
                        dealerScore = dealerScore - 10;
                        nDealerAces--;
                    }
                    cardForImage = dealerCard6.getCardImage();
                    dealerCard6Image = new ImageIcon(cardForImage);
                    dealerCard6Label.setIcon(dealerCard6Image);
                    dealerScoreLabel.setText("Dealer Score: " + dealerScore);
                }


                if (dealerScore > 21) {
                    dealerBusted = true;
                    bankroll.win();
                    handOutcome.setText("WON $" + betAmount);
                }
            }
        }
        endHand();
    }

    public void winner(){
        if (dealerScore == playerScore) {
            handOutcome.setText("PUSHED");
        } else if (playerScore > dealerScore) {
            bankroll.win();
            handOutcome.setText("WON $" + betAmount);
        } else {
            bankroll.loss();
            handOutcome.setText("LOST $" + betAmount);
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
        canStay = false;
        reshuffling.setText("");
    }

    public void endPlayerTurn(){
        if(stay){
            dealerTurn();
        }
    }

}
