package games.slotmachine;

import games.interfaces.Game;
import player.Player;
import util.RandomUtils;
import util.EqualityUtils;

import static games.slotmachine.SlotMachineDefaults.*;

public class SlotMachine implements Game {

    private Player registeredPlayer;
    private final SlotSymbol[] reelResults= new SlotSymbol[3];
    private double multiplier = 0;

    public SlotMachine(){

    }


    @Override
    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    @Override
    public void setRegisteredPlayer(Player player) {
        this.registeredPlayer = player;
    }


    /**
     * Checks if player wins the current spin, and also sets the multiplier.
     *
     * TODO: Separate the check from the multiplier setter.
     *
     * @param result the list of resulting symbols
     * @return true if the symbols are in a winning configuration
     */
    private boolean checkWin(SlotSymbol[] result){
        SlotSymbol slotSymbol1 = result[0];
        SlotSymbol slotSymbol2 = result[1];
        SlotSymbol slotSymbol3 = result[2];
        System.out.println("Checking win condition:");

        if(EqualityUtils.checkThreeEqual(slotSymbol1, slotSymbol2, slotSymbol3)) { // checks if all three are equal to each other
            if (BAR.equals(slotSymbol1)) { // all three are 'BAR'
                multiplier = 100;
                System.out.println("BAR!");

            } else if (SEVENS.equals(slotSymbol1)) { // all three are 'SEVENS'
                multiplier = 77;
                System.out.println("SEVENS!");

            }else{ // all three are the same type of 'Fruit'
                multiplier = 9;
                System.out.println("SAME FRUITS!");

            }
            return true;
        }

        if(slotSymbol1.getBasic() && slotSymbol2.getBasic() && slotSymbol3.getBasic()) { // all three are different fruits
            multiplier = 1.5;
            System.out.println("DIFFERENT FRUITS!");
            return true;
        }

        // if they are not equal or only different fruits, no pay out.
        multiplier = 0;
        System.out.println("No win.");
        return false;
    }


    /**
     * Method to "spin" the reels.
     *
     * TODO: Clean up. I dont think it's good practise with void, no-argument methods...
     */
    public void spinReel() {
        System.out.println("Spinning...");
        for (int i = 0; i < 3; i++) {
            int result = RandomUtils.randomBetween(0, SLOTS_SYMBOLS.size() - 1);
            reelResults[i] = SLOTS_SYMBOLS.get(result);
        }

    }

    /**
     * Multiplies the bet with the multiplier.
     * Also adds that result to the player balance and payout history.
     *
     * TODO: Clean up. Should maybe not do all this in one method.
     *
     * @param multiplier the multiplier to multiply the bet with
     * @param bet the bet the player makes
     * @return the resulting payout.
     */
    public double calculatePayout(double multiplier, double bet) {
        double payout = multiplier * bet;

        registeredPlayer.addToBalance(payout);
        registeredPlayer.addToPayoutHistory(payout);

        System.out.println("Updated player balance. New balance: " + registeredPlayer.getBalance());

        return payout;
    }

    /**
     * Helper function to convert a list of symbols to readable, printable String.
     *
     * @param slotSymbols a list of Symbol types.
     * @return String on the format | Symbol | Symbol | Symbol |.
     */
    public String symbolsToString(SlotSymbol[] slotSymbols){
        StringBuilder result = new StringBuilder();
        result.append("|");

        for (SlotSymbol slotSymbol : slotSymbols) {
            result.append(" ");
            result.append(slotSymbol.getName());
            result.append(" ");
            result.append("|");
        }

        return result.toString();
    }

    /**
     * Plays the machine.
     *
     * TODO: JavaFX Compatibility.
     *
     * @param bet the players bet.
     * @return String with the results.
     */
    public String play(double bet) {
        if (registeredPlayer == null){
            throw new NullPointerException("No player detected!");
        }
        if (registeredPlayer.getBalance() < 0){
            System.out.println("Player balance is 0!");
            return "Please add more to balance before trying again.";
        }
        if (registeredPlayer.getBalance() < bet){
            System.out.println("Player balance too low for that bet!");
            return "Please change bet.";
        }

        registeredPlayer.removeFromBalance(bet);

        spinReel();

        String result = "Your slots results are: ";
        if (checkWin(reelResults)) {
            result += symbolsToString(reelResults) + " Nice play!\n";

        } else {
            result += symbolsToString(reelResults) + " Try again!\n";
        }
        result += "Your payout: " + calculatePayout(multiplier, bet);
        return result;
    }

}