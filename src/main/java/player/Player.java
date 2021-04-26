package player;

import games.blackjack.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private double balance;

    // Blackjack
    private final List<Card> hand = new ArrayList<>();
    private int hardSum = 0;
    private int softSum = 0;


    public Player(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Players name must not be blank.");
        } else {
            this.name = name;
            this.balance = 0;
        }
    }

    public Player(String name, double balance) {
         if(name.isBlank()) {
            throw new IllegalArgumentException("Players name must not be blank.");
        } else if (isNegative(balance)) {
            throw new IllegalArgumentException("Players balance must be positive.");
        }
        else {
            this.name = name;
            this.balance = balance;
        }
    }

    public void updatePlayer(Player player) {
        setName(player.name);
        setBalance(player.balance);
    }

    /**
     * Returns player name as a String
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the players name
     */
    public void setName(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Players name must not be blank.");
        } else{
            this.name = name;
        }
    }

    /**
     * Returns player balance as a Double
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the players balance
     */
    public void setBalance(double balance) {
        if(isNegative(balance)) {
            throw new IllegalArgumentException("Balance must be positive.");
        } else{
            this.balance = balance;
        }
    }

    /**
     * Value must be positive.
     *
     * @param value to add to the balance
     */
    public void addToBalance(double value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException("Value to be added must be positive.");
        } else {
            this.balance += value;
        }
    }

    /**
     * Value cannot be greater than players balance.
     *
     * @param value to remove from the value
     */
    public void removeFromBalance(double value) {
        if (isGreaterThan(value, balance)) {
            throw new IllegalArgumentException("Value to be removed cannot be greater than the players balance.");
        } else {
            this.balance -= value;
        }
    }

    // Validation methods

    private boolean isNegative(double value) {
        return value < 0;
    }

    private boolean isGreaterThan(double val1, double val2) {
        return val1 > val2;
    }

    // Blackjack

    /**
     * Returns player hand
     * @return list of cards
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * @param card to add to the hand
     */
    public void addCardToHand(Card card) {
        hand.add(card);
        hardSum += card.getValue().getBjValue();
        softSum += card.getValue().getAltValue();
    }

    public int getHardSum() {
        return hardSum;
    }

    public int getSoftSum() {
        return softSum;
    }

    public String getTotalSum(){
        if (hardSum != softSum && hardSum < 21){
            return softSum+"/"+hardSum;
        }
        return Integer.toString(softSum);
    }
}