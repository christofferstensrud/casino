import games.BlackJack;
import games.BlackJackDefaults;
import games.SlotsMachine;
import player.Player;

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

        BlackJack bj = new BlackJack();
        bj.setRegisteredPlayer(pTest);
        bj.generateSortedDeck();
        bj.generateDeckRandom();
        bj.start();







        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }

}
