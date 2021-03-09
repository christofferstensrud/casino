import games.SlotsMachine;
import player.Player;

public class Main {

    public static void main(String[] args) {

        Player pTest = new Player("Test Testenson");
        System.out.println(pTest.getBalance());
        pTest.addToBalance(30);
        System.out.println(pTest.getBalance());

        SlotsMachine slotsMachine = new SlotsMachine();

    }

}
