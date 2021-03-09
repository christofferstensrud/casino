package player;

public class Player {

    private String name;
    private double balance;

    public Player(String name){
        this.name = name;
        this.balance = 0;
    }

    public Player(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    /**
     * Returns player.Player name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name to change player.Player name to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns player.Player balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param value to set the balance to
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * @param value to add to the balance
     */
    public void addToBalance(double value) {
        this.balance += value;
    }

    /**
     * @param value to remove from the value
     */
    public void removeFromBalance(double value) {
        this.balance -= value;
    }
}
