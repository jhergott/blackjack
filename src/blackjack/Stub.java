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

    private JPanel panel;
    private JPanel panel2;
    private JButton hit;
    private JButton stand;
    private JButton doubleDown;
    private JButton bet;
    private JButton cashOut;
    private String cardForImage;
    private ImageIcon cardImage;
    private JLabel cardLabel;
    private DeckShoe deckShoe;

    public Stub(){
        createComponents();
        setSize(500,500);
    }

    //fix below
    /*class TestListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            Card cardDealt2 = deckShoe.dealCard();
            cardForImage = cardDealt2.getCardImage();
            System.out.println(cardDealt2.getCardValue());
            cardImage = new ImageIcon(cardForImage);
            cardLabel = new JLabel(cardImage);
            panel.add(cardLabel);
            add(panel);
            repaint();
        }
    }*/


    public void createComponents(){
        panel = new JPanel();
        panel2 = new JPanel(new GridLayout());
        panel.setBackground(Color.GREEN.darker().darker());


        deckShoe = new DeckShoe();
        Card cardDealt = deckShoe.dealCard();
        cardForImage = cardDealt.getCardImage();
        System.out.println(cardDealt.getCardValue());

        int cardNumber = 12;
        hit = new JButton("HIT");
        stand = new JButton("STAND");
        doubleDown = new JButton("DOUBLE DOWN");
        bet = new JButton("Bet");
        ActionListener listener = new TestListener();
        bet.addActionListener(listener);

        cashOut = new JButton("Cash Out");
        //cardImage = new ImageIcon("cards/" + cardNumber +".png");
        cardImage = new ImageIcon(cardForImage);
        cardLabel = new JLabel(cardImage);

        panel.add(panel2);
        panel2.add(hit);
        panel2.add(stand);
        panel2.add(doubleDown);
        panel2.add(bet);
        panel2.add(cashOut);
        panel.add(cardLabel);
        add(panel);
    }

}
