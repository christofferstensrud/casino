package games.slot;

import org.junit.Before;
import player.Player;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSlot {

    public Player player;
    public Slot slot;

    @Before
    public void setUp(){
        player = new Player("testPerson");
        slot = new Slot();
    }

    @Test
    public void testRegisterPlayer() {
        slot.setRegisteredPlayer(player);
        assertEquals(player, slot.getRegisteredPlayer());
    }
}
