package casino.player;

import casino.games.blackjack.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int balance;

    // Blackjack
    private final List<Card> hand = new ArrayList<>();
    private int hardSum = 0;
    private int softSum = 0;


    public Player(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank.");
        } else {
            this.name = name;
            this.balance = 0;
        }
    }

    public Player(String name, int balance) {
         if(name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank.");
        } else if (isNegative(balance)) {
            throw new IllegalArgumentException("Player balance must be positive.");
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
            throw new IllegalArgumentException("Player name cannot be blank.");
        } else{
            this.name = name;
        }
    }

    /**
     * Returns player balance as a int
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the players balance
     */
    public void setBalance(int balance) {
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
    public void addToBalance(int value) {
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
    public void removeFromBalance(int value) {
        if (isGreaterThan(value, balance)) {
            throw new IllegalArgumentException("Value to be removed cannot be greater than the players balance.");
        } else {
            this.balance -= value;
        }
    }

    // Validation methods

    boolean isNegative(int value) {
        return value < 0;
    }

    private boolean isGreaterThan(int val1, int val2) {
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
