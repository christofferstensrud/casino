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

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public boolean getBasic() {
        return basic;
    }
}
