package games.slot;

import casino.games.slot.Slot;
import casino.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSlot {

    public Player player= new Player("testPerson");;
    public Slot slot= new Slot();

    @Test
    public void test_set_register_player() {
        slot.setRegisteredPlayer(player);
        assertEquals(player, slot.getRegisteredPlayer());
    }

    @Test
    public void test_play_without_registered_player() {
        player.addToBalance(5);

        Exception exception = assertThrows(
                NullPointerException.class, () -> {
                    slot.play(5);
                });

        String expectedMessage = "No player detected!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(5, player.getBalance());
    }


}
