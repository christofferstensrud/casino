package games;

import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import util.RandomFunc;

public class SlotsMachine implements Game{

    private Player registeredPlayer;

    private final List<String> SYMBOLS = Arrays.asList("cherry", "melon", "lemon", "seven", "bar");


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



    private double calculateMultiplier(int[] result){
        return 0;
    }

    private double calculatePayout(double bet){
        return 0;
    }

    public String spinReel() {
        int reel = RandomFunc.randomBetween(0, SYMBOLS.size() - 1);

        return SYMBOLS.get(reel);
    }

    public String play() {
        List<String> results= new ArrayList<>();
        results.add(spinReel());
        results.add(spinReel());
        results.add(spinReel());

        if (results.get(0).equals(results.get(1)) && results.get(0).equals(results.get(2))){
            return "You got: " + results + " and WON! Nice play!";

        }else
            return "You got: " + results + " and did not win, try again!";
    }

}
