package games.slot;

import interfaces.Game;
import player.Player;
import util.RandomUtils;
import util.EqualityUtils;

import static games.slot.SlotDefaults.*;

public class Slot implements Game {

    private Player registeredPlayer;
    private final SlotSymbol[] reelResults;
    private double multiplier;
    private String winCom;

    public Slot(){
        this.reelResults = new SlotSymbol[3];
        this.multiplier = 0;
    }

    @Override
    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    @Override
    public void setRegisteredPlayer(Player player) {
        this.registeredPlayer = player;
    }

    public SlotSymbol[] getReelResults() {
        return this.reelResults;
    }

    public String getWinCom() {
        return this.winCom;
    }

    public double getMultiplier() {
        return this.multiplier;
    }


    /**
     * Checks if player wins the current spin, and also sets the correct multiplier.
     *
     * Has 3 outcomes:
     *
     * <ul>
     *     <li>Same symbols</li>
     *     <li>Different fruits</li>
     *     <li>No win</li>
     * </ul>
     *
     * @param result the list of resulting symbols
     * @return true if the symbols are in a winning configuration
     */
    private boolean checkWin(SlotSymbol[] result){
        SlotSymbol slotSymbol1 = result[0];
        SlotSymbol slotSymbol2 = result[1];
        SlotSymbol slotSymbol3 = result[2];

        if(EqualityUtils.checkThreeEqual(slotSymbol1, slotSymbol2, slotSymbol3)) { // checks if all three are equal to each other
            multiplier = slotSymbol1.getMultiplierValue();
            winCom = "SAME SYMBOLS!";
            return true;
        }

        if(slotSymbol1.getBasic() && slotSymbol2.getBasic() && slotSymbol3.getBasic()) { // all three are different fruits
            multiplier = slotSymbol1.getMultiplierValue()/2;
            winCom = "DIFFERENT FRUITS!";
            return true;
        }

        // if they are not equal or only different fruits, no pay out.
        multiplier = 0;
        winCom = "No win!";
        return false;
    }


    /**
     * Method to "spin" the reels.
     *
     * Updates reelResults with three random symbols.
     *
     */
    private void spinReel() {
        for (int i = 0; i < 3; i++) {
            int result = RandomUtils.randomBetween(0, SLOTS_SYMBOLS.size() - 1);
            reelResults[i] = SLOTS_SYMBOLS.get(result);
        }

    }

    /**
     * Multiplies the bet with the multiplier.
     * Also adds that result to the player balance and payout history.
     *
     * @param multiplier the multiplier to multiply the bet with
     * @param bet the bet the player makes
     * @return the resulting payout.
     */
    private double calculatePayout(double multiplier, double bet) {
        return multiplier * bet;
    }

    /**
     * Plays the machine.
     *
     * @param bet the players bet.
     * @return String with the results.
     */
    public boolean play(double bet) {
        if (registeredPlayer == null){
            throw new NullPointerException("No player detected!");
        }
        if (registeredPlayer.getBalance() < 0){
            return false;
        }
        if (registeredPlayer.getBalance() < bet){
            return false;
        }

        registeredPlayer.removeFromBalance(bet);

        spinReel();
        if(checkWin(reelResults)){
            registeredPlayer.addToBalance(calculatePayout(multiplier, bet));
        }

        return true;
    }
}
