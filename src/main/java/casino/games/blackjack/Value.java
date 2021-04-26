package casino.games.blackjack;

public class Value {

    private final String name;
    private final int value;
    private final int bjValue;
    private int altValue;

    public Value(String name, int value){
        this.name = name;
        this.value = value;
        this.bjValue = value;
    }

    public Value(String name, int value, int bjValue){
        this.name = name;
        this.value = value;
        this.bjValue = bjValue;
    }

    public Value(String name, int value, int bjValue, int altValue){
        this.name = name;
        this.value = value;
        this.bjValue = bjValue;
        this.altValue = altValue;
    }

    public String getName() {
        return name;
    }

    public String getValueAsString(boolean convertFaceValues) {
        if(convertFaceValues){
            switch (value){
                case 11:
                    return "J";
                case 12:
                    return "Q";
                case 13:
                    return "K";
                case 14:
                    return "A";
            }
        }
        return ""+value;
    }

    public int getValue() {
        return value;
    }

    public int getBjValue() {
        if (this.bjValue == 0){
            return value;
        }
        return bjValue;
    }

    public int getAltValue() {
        if (this.altValue == 0){
            return getBjValue();
        }
        return altValue;
    }
}
