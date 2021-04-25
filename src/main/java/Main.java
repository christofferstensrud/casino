import games.blackjack.Blackjack;
import games.slot.Slot;
import player.Player;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Player pTest = new Player("Test Testenson");
        pTest.addToBalance(100);

        Slot slot = new Slot();
        slot.setRegisteredPlayer(pTest);
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(slot.play(5));
        System.out.println(pTest.getPayoutHistory());
        pTest.printPayoutToFile();

        /*Blackjack bj = new Blackjack();
        bj.setRegisteredPlayer(pTest);
        bj.start();

        bj.playDealer();
        System.out.println(bj.getHistory());*/







        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }

}
