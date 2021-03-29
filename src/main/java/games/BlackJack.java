package games;

import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static games.BlackJackDefaults.SUITS;
import static games.BlackJackDefaults.VALUES;
import static util.RandomUtils.randomBetween;
import static util.RandomUtils.randomize;

public class BlackJack implements Game{

    private Player registeredPlayer;
    private final List<Card> playerHand = new ArrayList<>();
    private final List<Card> dealerHand = new ArrayList<>();
    private final List<Card> sortedDeck = new ArrayList<>();
    private final List<Card> playableDeck = new ArrayList<>();

    public BlackJack() {

    }

    @Override
    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    @Override
    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }

    public void hit(Card[] hand) {

    }

    public void stand(){

    }

    public void start() {
        /*playerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));*/

    }


    public void generateSortedDeck(){

        for (Suit suit : SUITS) {
            for (Value value : VALUES) {
                sortedDeck.add(new Card(suit, value));
            }
        }

    }


    public void generateDeckRandom(){
        System.out.println(sortedDeck);
        System.out.println(Arrays.toString(randomize(sortedDeck.toArray(), sortedDeck.size())));
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
