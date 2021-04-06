package games;

import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static games.BlackjackDefaults.SUITS;
import static games.BlackjackDefaults.VALUES;
import static util.RandomUtils.*;

public class Blackjack implements Game{

    private Player registeredPlayer;
    private String currentPlayer;
    private List<Card> playerHand = new ArrayList<>();
    private List<Card> dealerHand = new ArrayList<>();

    private final List<Card> sortedDeck = new ArrayList<>();
    public List<Card> playableDeck = new ArrayList<>();

    private String[] turnHistory = new String[0];

    private boolean isDealersTurn = false;

    //private int maxPlayers = 1;

    public Blackjack() {

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

    public void hit(List<Card> hand) {
        System.out.println(currentPlayer + " hits.");
        hand.add(playableDeck.remove(0)); // removes the card on the top of the deck and gives it to the player
        //calculateHand(hand);
    }

    public void stand(List<Card> hand) {
        System.out.println(currentPlayer + " stands.");

    }

    public void doubleDown(List<Card> hand) {

    }

    public void split(List<Card> hand) {

    }

    public void surrender(List<Card> hand) {

    }


    public void start() {
        /*playerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));*/

    }

    /**
     * Helper function to generate a standard 52-card deck.
     * In the order: ♤->♢->♧->♡
     * King down to Ace
     */
    public void generateSortedDeck(){
        for (Suit suit : SUITS) {
            for (Value value : VALUES) {
                sortedDeck.add(new Card(suit, value));
            }
        }
    }

    public void generateMultipleDecks(int numberOfDecks){
        List<Card> deck = new ArrayList<>();

        for (int i = 0; i <= numberOfDecks; i++) {
            deck.addAll(sortedDeck);
        }

        Card[] deckArr = deck.toArray(Card[]::new); //convert List<Card> to Card[]

        //generate a random permutation of deckArr
        playableDeck = Arrays.asList(randomPermutation(deckArr, deckArr.length));
    }


    public String toStringDeck(List<Card> cards){
        StringBuilder result = new StringBuilder();

        for (Card card : cards) {
            result.append(card.toString());
            result.append(", ");
        }

        return result.toString();
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
