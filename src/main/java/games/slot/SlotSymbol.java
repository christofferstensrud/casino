package games.slot;

public class SlotSymbol {

    private final String name;
    private final char symbol;
    private final double multiplierValue;
    private final boolean basic;

    public SlotSymbol(String name, char symbol, double multiplierValue, boolean isBasic){
        this.name = name;
        this.symbol = symbol;
        this.multiplierValue = multiplierValue;
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
    public double getMultiplierValue() {
        return multiplierValue;
    }

    /**
     *
     * @return true if the symbol is a basic symbol, in slots the basic symbols are the fruits.
     */
    public boolean getBasic() {
        return basic;
    }
}
