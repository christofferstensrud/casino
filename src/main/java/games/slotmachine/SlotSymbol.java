package games.slotmachine;

public class SlotSymbol {

    private final String name;
    private final char symbol;
    private final double value;
    private final boolean basic;

    public SlotSymbol(String name, char symbol, double value, boolean isBasic){
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
     * @return symbol of the slotssymbol
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
