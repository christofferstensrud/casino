package games.slot;

import casino.games.slot.Slot;
import casino.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSlot {

    public Player player= new Player("testPerson");;
    public Slot slot= new Slot();

    @Test
    public void testSetRegisterPlayer() {
        slot.setRegisteredPlayer(player);
        assertEquals(player, slot.getRegisteredPlayer());
    }



}
