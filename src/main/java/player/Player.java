package player;

import games.blackjack.Card;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private double balance;

    private final List<Card> hand = new ArrayList<>();
    private int hardSum = 0;
    private int softSum = 0;

    private final List<String> payoutHistory = new ArrayList<>();


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
     * Returns the players payout history as a list of Strings
     * @return payoutHistory
     */
    public List<String> getPayoutHistory() {
        return payoutHistory;
    }

    /**
     * @param payout to add to the payout history
     */
    public void addToPayoutHistory(String game, String resultsAsString, double bet, double payout) {
        this.payoutHistory.add(game +
                " | " +
                resultsAsString +
                " | " +
                bet +
                " | " +
                payout);
    }

    public void printPayoutToFile() throws IOException {
        try {
            FileWriter payoutHistoryFile = new FileWriter(getName() +" payout history.txt");

            StringBuilder result = new StringBuilder();
            for (String line : payoutHistory) {
                result.append(line);
                result.append("\n");
            }
            String header = "Game | Results | Bet | Payout \n";
            payoutHistoryFile.write(header);
            payoutHistoryFile.append(result.toString());
            payoutHistoryFile.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

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
