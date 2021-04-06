import games.blackjack.Blackjack;
import games.slotmachine.SlotMachine;
import player.Player;

public class Main {

    public static void main(String[] args) {

        Player pTest = new Player("Test Testenson");
        pTest.addToBalance(30);

        SlotMachine slotMachine = new SlotMachine();
        /*slotsMachine.setRegisteredPlayer(pTest);
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));*/

        Blackjack bj = new Blackjack();
        bj.setRegisteredPlayer(pTest);
        System.out.println(bj.playableDeck);
        bj.hit(bj.playerHand);
        System.out.println(bj.getHistory());
        System.out.println(bj.playableDeck);







        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }

}
