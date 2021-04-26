package casino.interfaces;

import casino.player.Player;

import java.io.IOException;

public interface FileHandlingInterface {

    /**
     * @return the state of the player.
     */
    Player readPlayerState() throws IOException;

    /**
     * Prints the state of a player to a file.
     *
     * @return true if the player data was printed.
     */
    boolean printPlayerState();


}
