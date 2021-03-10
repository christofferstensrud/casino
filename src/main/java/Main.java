import games.SlotsMachine;
import player.Player;
import util.RandomFunc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*Player pTest = new Player("Test Testenson");
        System.out.println(pTest.getBalance());
        pTest.addToBalance(30);
        System.out.println(pTest.getBalance());*/

        SlotsMachine slotsMachine = new SlotsMachine();
        System.out.println(slotsMachine.play(1));




        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }

}
