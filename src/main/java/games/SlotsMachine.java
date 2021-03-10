package games;

import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static games.SlotsMachineDefaults.*;

import util.RandomFunc;

public class SlotsMachine implements Game{

    private Player registeredPlayer;

    private final Symbol[] reelResults= new Symbol[3];

    private double multiplier = 0;

    public SlotsMachine(){

    }


    @Override
    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    @Override
    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }


    private <T> boolean checkThreeEqual(T a, T b, T c){ // Generic method so it can check every type.
        return (a == b) && (a == c);
    }

    private boolean checkWin(Symbol[] result){
        Symbol symbol1 = result[0];
        Symbol symbol2 = result[1];
        Symbol symbol3 = result[2];
        System.out.println("Checking win condition:");

        if(checkThreeEqual(symbol1, symbol2, symbol3)) {
            if (BAR.equals(symbol1)) { // all three are 'BAR'
                multiplier = 100;
                System.out.println("BAR!");
            } else if (SEVENS.equals(symbol1)) { // all three are 'SEVENS'
                multiplier = 77;
                System.out.println("SEVENS!");
            }else{// all three are the same 'Fruit'
                multiplier = 3;
                System.out.println("SAME FRUITS!");
            }
            return true;
        }
        if(symbol1.getBasic() && symbol2.getBasic() && symbol3.getBasic()) { // all three are different fruits
            multiplier = 1.5;
            System.out.println("DIFFERENT FRUITS!");
            return true;
        }

        multiplier = 0;
        System.out.println("No win.");
        return false;
    }


    public void spinReel() {
        System.out.println("Spinning...");
        for (int i = 0; i < 3; i++) {
            int result = RandomFunc.randomBetween(0, SYMBOLS.size() - 1);
            reelResults[i] = SYMBOLS.get(result);
        }

    }

    public double calculatePayout(double multiplier, double bet) {
        double payout = multiplier * bet;

        registeredPlayer.addToBalance(payout);
        registeredPlayer.addToPayoutHistory(payout);

        System.out.println("Updated player balance. New balance: " + registeredPlayer.getBalance());

        return payout;
    }

    public String symbolsToString(Symbol[] symbols){
        StringBuilder result = new StringBuilder();
        result.append("|");

        for (Symbol symbol : symbols) {
            result.append(" ");
            result.append(symbol.getName());
            result.append(" ");
            result.append("|");
        }

        return result.toString();
    }

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
