package games;

public class Symbol {

    private final String name;
    private final char symbol;
    private final double value;
    private final boolean basic;

    public Symbol(String name, char symbol, double value, boolean isBasic){
        this.name = name;
        this.symbol = symbol;
        this.value = value;
        this.basic = isBasic;
    }

    /**
     *
     * @return name of the symbol
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return "symbol" of the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     *
     * @return symbol value, if needed to rank them accordingly
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @return true if the symbol is a basic symbol, in slots the basic symbols are the fruits.
     */
    public boolean getBasic() {
        return basic;
    }
}
