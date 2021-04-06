import games.Blackjack;
import games.SlotsMachine;
import player.Player;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Player pTest = new Player("Test Testenson");
        pTest.addToBalance(30);

        SlotsMachine slotsMachine = new SlotsMachine();
        /*slotsMachine.setRegisteredPlayer(pTest);
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));*/

        Blackjack bj = new Blackjack();
        bj.setRegisteredPlayer(pTest);
        bj.generateSortedDeck();
        bj.generateMultipleDecks(8);
        System.out.println(bj.playableDeck);
        bj.start();







        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }

}
