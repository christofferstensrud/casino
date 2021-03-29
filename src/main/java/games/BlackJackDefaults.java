package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackDefaults {

    public static final Suit SPADE = new Suit("Spade", "♠","♤");
    public static final Suit DIAMOND = new Suit("Diamond", "♦","♢");
    public static final Suit CLUB = new Suit("Club", "♣","♧");
    public static final Suit HEART = new Suit("Heart", "♥","♡");

    public static final List<Suit> SUITS = Arrays.asList(SPADE,DIAMOND,CLUB,HEART);

    public static final Value KING = new Value("King", 13, 10);
    public static final Value QUEEN = new Value("Queen", 12, 10);
    public static final Value JACK = new Value("Jack", 11, 10);
    public static final Value TEN = new Value("Ten", 10);
    public static final Value NINE = new Value("Nine", 9);
    public static final Value EIGHT = new Value("Eight", 8);
    public static final Value SEVEN = new Value("Seven", 7);
    public static final Value SIX = new Value("Six", 6);
    public static final Value FIVE = new Value("Five", 5);
    public static final Value FOUR = new Value("Four", 4);
    public static final Value THREE = new Value("Three", 3);
    public static final Value DEUCE = new Value("Deuce", 2);
    public static final Value ACE = new Value("Ace", 14, 11, 1);

    public static final List<Value> VALUES = Arrays.asList(KING,QUEEN,JACK,TEN,NINE,EIGHT,SEVEN,SIX,FIVE,FOUR,THREE,DEUCE,ACE);
    public static final List<Value> FACE_VALUES = Arrays.asList(KING,QUEEN,JACK);


}
