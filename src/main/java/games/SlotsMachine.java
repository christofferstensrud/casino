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
                multiplier = 1000;
                System.out.println("BAR!");
            } else if (SEVENS.equals(symbol1)) { // all three are 'SEVENS'
                multiplier = 777;
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

    public String symbolsToString(Symbol[] symbols){
        StringBuilder result = new StringBuilder();

        for (Symbol symbol : symbols) {
            result.append(symbol.getName());
            result.append(", ");
        }

        return result.toString();
    }

    public String play(double bet) {
        spinReel();
        if (checkWin(reelResults)){
            return "You got: " + symbolsToString(reelResults) + " and WON "+ multiplier + "! Nice play!";

        }else
            return "You got: " + symbolsToString(reelResults) + " and did not win, try again!";
    }

}
