package games.blackjack;

public class Suit {

    private final String suit;
    private final String symbolB;
    private final String symbolW;

    public Suit(String suit, String symbolB, String symbolW){
        this.suit = suit;
        this.symbolB = symbolB;
        this.symbolW = symbolW;

    }

    public String getSuit() {
        return suit;
    }

    public String getSymbolB() {
        return symbolB;
    }

    public String getSymbolW() {
        return symbolW;
    }

}
