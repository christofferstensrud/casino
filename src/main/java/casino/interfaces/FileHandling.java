package casino.interfaces;

import casino.player.Player;
import java.io.IOException;

public interface FileHandling {

    /**
     * @return the state of the player.
     */
    Player readPlayerState() throws IOException;

    /**
     * Prints the state of a player.
     *
     * @param player the player to print to file.
     */
    boolean printPlayerState(Player player);


}
