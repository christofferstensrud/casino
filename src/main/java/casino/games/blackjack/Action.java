package casino.games.blackjack;

public class Action {

    private boolean isAvailable;
    private final String NAME;

    public Action(String name, boolean isAvailable){
        this.NAME = name;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return NAME;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
