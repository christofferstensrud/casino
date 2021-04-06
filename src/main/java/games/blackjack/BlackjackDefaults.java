package games.blackjack;

import player.Player;

import java.util.Arrays;
import java.util.List;

public class BlackjackDefaults {

    static final Player DEALER = new Player("Dealer");

    private static final Suit SPADE = new Suit("Spade", "♠","♤");
    private static final Suit DIAMOND = new Suit("Diamond", "♦","♢");
    private static final Suit CLUB = new Suit("Club", "♣","♧");
    private static final Suit HEART = new Suit("Heart", "♥","♡");

    static final List<Suit> SUITS = Arrays.asList(SPADE,DIAMOND,CLUB,HEART);

    private static final Value KING = new Value("King", 13, 10);
    private static final Value QUEEN = new Value("Queen", 12, 10);
    private static final Value JACK = new Value("Jack", 11, 10);
    private static final Value TEN = new Value("Ten", 10);
    private static final Value NINE = new Value("Nine", 9);
    private static final Value EIGHT = new Value("Eight", 8);
    private static final Value SEVEN = new Value("Seven", 7);
    private static final Value SIX = new Value("Six", 6);
    private static final Value FIVE = new Value("Five", 5);
    private static final Value FOUR = new Value("Four", 4);
    private static final Value THREE = new Value("Three", 3);
    private static final Value DEUCE = new Value("Deuce", 2);
    private static final Value ACE = new Value("Ace", 14, 11, 1);

    static final List<Value> VALUES = Arrays.asList(KING,QUEEN,JACK,TEN,NINE,EIGHT,SEVEN,SIX,FIVE,FOUR,THREE,DEUCE,ACE);
    static final List<Value> FACE_VALUES = Arrays.asList(KING,QUEEN,JACK);

    static final Action HIT = new Action("Hit", true);
    static final Action STAND = new Action("Stand", true);
    static final Action DOUBLE_DOWN = new Action("Double down", true);
    static final Action SPLIT = new Action("Split", true);
    static final Action SURRENDER = new Action("Surrender", true);

    static final List<Action> ACTIONS = Arrays.asList(HIT, STAND, DOUBLE_DOWN, SPLIT, SURRENDER);

    void setAllAvailable(boolean isAvailable){
        for (Action action:
                ACTIONS) {
            action.setAvailable(isAvailable);
        }
    }

    void setAvailableMult(boolean isAvailable, Action... actions){
        for (Action action:
             actions) {
            action.setAvailable(isAvailable);
        }
    }

}
