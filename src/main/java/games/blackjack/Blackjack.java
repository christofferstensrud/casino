package games.blackjack;

import games.interfaces.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import player.Player;

import static games.blackjack.BlackjackDefaults.*;

public class Blackjack implements Game {

    public ArrayList<Card> playableDeck;

    private Player registeredPlayer;
    private Player currentPlayer;

    private final List<String> turnHistory = new ArrayList<>();

    private final List<Action> actions = BlackjackDefaults.ACTIONS;

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

    private void nextPlayer(){
        if (currentPlayer == DEALER)
            currentPlayer = registeredPlayer;
        else
            currentPlayer = DEALER;
    }




    private void checkBust(Player player){
        if (player.getSoftSum() > 21) {
            addToHistory(player.getName() +
                    " busted.");

        }
    }


    // History functions

    public String getHistory() {
        StringBuilder history = new StringBuilder();

        for (String line : turnHistory) {
            history.append(line);
            history.append("\n");
        }
        return history.toString();
    }

    private void addToHistory(String event){
        turnHistory.add(event);
    }

    // if no cards drawn
    private String createEvent(Player player, Action action){
        return player.getName() +
                " " +
                action.getName() +
                "s";
    }

    // if cards are being dealt in the beginning
    private String createEvent(Player player, Card card){
        return player.getName() +
                " got " +
                card +
                ". They now have: " +
                player.getHand() +
                ". Total: " +
                player.getTotalSum();
    }

    // if cards are being hit
    private String createEvent(Player player, Action action, Card card){
        return player.getName() +
                " " +
                action.getName() +
                "s, they got " +
                card +
                ". They now have: " +
                player.getHand() +
                ". Total: " +
                player.getTotalSum();
    }



    // Actions

    /**
     * Filters out all unavailable actions
     * @return list of available actions
     */
    private List<Action> getAvailableActions() {
        return actions
                .stream()
                .filter(Action::isAvailable)
                .collect(Collectors.toList());
    }

    private void updateAvailableActions(Player player){
        if (player.getSoftSum() > 21){

        }
    }


    public void hit(Player player) {
        if(!getAvailableActions().contains(HIT)){
            throw new IllegalCallerException("Action 'hit' is unavailable");
        }

        deal(player, HIT);
        checkBust(player);
    }

    public void stand(Player player) {
        if(!getAvailableActions().contains(STAND)){
            throw new IllegalCallerException("Action 'stand' is unavailable");
        }

        addToHistory(createEvent(player, STAND));
        nextPlayer();
    }

    public void doubleDown(Player player) {
        if(!getAvailableActions().contains(DOUBLE_DOWN)){
            throw new IllegalCallerException("Action 'double down' is unavailable");
        }

        deal(player, DOUBLE_DOWN);
        checkBust(player);

    }

    public void split(Player player) {
        if(!getAvailableActions().contains(SPLIT)){
            throw new IllegalCallerException("Action 'split' is unavailable");
        }

        addToHistory(createEvent(player, SPLIT));
    }

    public void surrender(Player player) {
        if(!getAvailableActions().contains(SURRENDER)){
            throw new IllegalCallerException("Action 'surrender' is unavailable");
        }

        addToHistory(createEvent(player, SURRENDER));
    }

    private void deal(Player player, Action action) {
        Card newCard = playableDeck.remove(0); // removes the card on the top of the deck
        player.addCardToHand(newCard);

        addToHistory(createEvent(player, action, newCard));
    }

    private void deal(Player player) {
        Card newCard = playableDeck.remove(0); // removes the card on the top of the deck
        player.addCardToHand(newCard);

        addToHistory(createEvent(player, newCard));
    }



    // Playing blackjack
    public void playDealer() {

        while (DEALER.getHardSum() < 17 ||
                (DEALER.getSoftSum() <= 17 &&
                        DEALER.getSoftSum() != DEALER.getHardSum())) {
            hit(DEALER);
        }
        stand(DEALER);

    }


    // Starting function
    public void start() {
        currentPlayer = registeredPlayer;
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();

    }


    // Helping functions
    /**
     * Helper function to generate a standard 52-card deck.
     * In the order: ♤->♢->♧->♡
     * King down to Ace
     */
    public ArrayList<Card> generateSortedDeck(){
        ArrayList<Card> sortedDeck = new ArrayList<>(52);

        for (Suit suit : BlackjackDefaults.SUITS) {
            for (Value value : BlackjackDefaults.VALUES) {
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
        for (Card card : DEALER.getHand()) {
            result.append(card.toString());
        }
        result.append("]\n");


        result.append("Players hand: [");
        for (Card card : registeredPlayer.getHand()) {
            result.append(card.toString());
        }
        result.append("]\n");

        return result.toString();
    }

}
