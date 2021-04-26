package casino.games.slot;

public class SlotSymbol {

    private final String name;
    private final String path;
    private final int multiplierValue;
    private final boolean basic;

    public SlotSymbol(String name, String path, int multiplierValue, boolean isBasic){
        this.name = name;
        this.path = path;
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
     * @return Path of the slotsymbol
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @return Multiplier value
     */
    public int getMultiplierValue() {
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
