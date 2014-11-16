package blackjack;

/**
 * Created by jakehergott on 11/13/14.
 */
public class Bankroll {

    private double bankroll;
    private double bet;

    public Bankroll(){
        this.bankroll = 1000.0;
    }

    public double getBankroll(){
        return bankroll;
    }

    public void setBankroll(double bankroll) {
        this.bankroll = bankroll;
    }

    public void bet(double b){
        bet = b;
    }

    public void win(){
        bankroll += bet;
    }

    public void loss(){
        bankroll -= bet;
    }

    public void blackJack(){
        bankroll += bet * 1.5;
    }


}
