package games.slot;

import player.Player;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSlot {

    protected Player player;
    protected Slot slot;

    protected void setUp(){
        player = new Player("testPerson");
        slot = new Slot();
    }

    @Test
    public void testRegisterPlayer() {
        slot.setRegisteredPlayer(player);
        assertEquals(player, slot.getRegisteredPlayer());
    }
}
