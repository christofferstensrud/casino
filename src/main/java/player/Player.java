package player;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private double balance;

    private final List<Double> payoutHistory = new ArrayList<>();


    public Player(String name){
        this.name = name;
        this.balance = 0;
    }

    public Player(String name, double balance){
        this.name = name;
        this.balance = balance;
    }


    /**
     * Returns player name as a String
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name to change player name to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns player balance as a Double
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param value to set the balance to
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * @param value to add to the balance
     */
    public void addToBalance(double value) {
        this.balance += value;
    }

    /**
     * @param value to remove from the value
     */
    public void removeFromBalance(double value) {
        this.balance -= value;
    }

    /**
     * Returns the players payout history as a List of doubles
     * @return payoutHistory
     */
    public List<Double> getPayoutHistory() {
        return payoutHistory;
    }

    /**
     * @param payout to add to the payout history
     */
    public void addToPayoutHistory(double payout) {
        this.payoutHistory.add(payout);
    }


}
