package games.blackjack;

import games.interfaces.Game;
import player.Player;

import java.util.ArrayList;
import java.util.List;

import static games.blackjack.BlackjackDefaults.SUITS;
import static games.blackjack.BlackjackDefaults.VALUES;

public class Blackjack implements Game {

    public ArrayList<Card> playableDeck;

    private Player registeredPlayer;
    private String currentPlayer;

    public List<Card> playerHand = new ArrayList<>();
    private List<Card> dealerHand = new ArrayList<>();

    private int turnIndicator = 0;
    private List<String> turnHistory = new ArrayList<>();

    private boolean isDealersTurn = false;

    //private int maxPlayers = 1;

    public Blackjack() {
        ArrayList<Card> sortedDeck = generateSortedDeck(); // generates a standard 52-card deck
        playableDeck = generateMultipleDecks(sortedDeck, 8); // shuffles 8 standard decks together
    }

    @Override
    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    @Override
    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }

    /**
     * Calculates the sum of the players hand.
     *
     * TODO: Maybe do it so that the sum is tallying, and adds as the player receives a new card instead of adding everything again each time.
     *
     * @param hand the hand to calculate.
     * @return the sum
     */
    private int calculateHand(List<Card> hand){
        int sum = 0;
        int altSum = 0;

        for (Card card : hand) {
            sum += card.getValue().getBjValue();
            altSum += card.getValue().getAltValue();
        }

        if (altSum > 21){
            playerBust(altSum);
            return altSum;
        }

        if (sum > 21){
            return altSum;
        }

        return sum;
    }

    private void playerBust(int sum){
        System.out.println(currentPlayer + " busted, they had " + sum);
    }

    public void turn(List<Card> hand){
        if (isDealersTurn) {
            currentPlayer = "DEALER";

            while (calculateHand(hand) <= 17) {
                hit(hand);
            }
            stand(hand);
        }else {
            currentPlayer = registeredPlayer.getName();


        }
    }

    // Turnhistory Functions

    public String getHistory() {
        StringBuilder history = new StringBuilder();

        for (String line : turnHistory) {
            history.append(line);
        }
        return history.toString();
    }

    private void addToHistory(String event){
        turnHistory.add(event);
    }

    private String createEvent(Player player, String action){
        return player.getName() +
                " " +
                action +
                "s";
    }

    private String createEvent(Player player, String action, Card card){
        return player.getName() +
                " " +
                action +
                "s, they got " +
                card +
                ". Total: " +
                calculateHand(playerHand);
    }



    // Actions
    public void hit(List<Card> hand) {
        Card newCard = playableDeck.remove(0); // removes the card on the top of the deck
        hand.add(newCard);
        addToHistory(createEvent(registeredPlayer, "hit", newCard));
    }

    public void stand(List<Card> hand) {
        addToHistory(createEvent(registeredPlayer, "stand"));
    }

    public void doubleDown(List<Card> hand) {

    }

    public void split(List<Card> hand) {

    }

    public void surrender(List<Card> hand) {

    }

    private void deal() {

    }

    private List<String> getAvailableActions() {
        return null;
    }

    // Starting function
    public void start() {
        /*playerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));*/

    }


    // Helping functions
    /**
     * Helper function to generate a standard 52-card deck.
     * In the order: ♤->♢->♧->♡
     * King down to Ace
     */
    public ArrayList<Card> generateSortedDeck(){
        ArrayList<Card> sortedDeck = new ArrayList<>(52);

        for (Suit suit : SUITS) {
            for (Value value : VALUES) {
                sortedDeck.add(new Card(suit, value));
            }
        }
        return sortedDeck;
    }

    public ArrayList<Card> generateMultipleDecks(List<Card> initialList, int numberOfTimes){
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < numberOfTimes; i++) {
            deck.addAll(initialList);
        }
        java.util.Collections.shuffle(deck);

       return deck;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Dealers hand: [");
        for (Card card : dealerHand) {
            result.append(card.toString());
        }
        result.append("]\n");


        result.append("Players hand: [");
        for (Card card : playerHand) {
            result.append(card.toString());
        }
        result.append("]\n");

        return result.toString();
    }

}
