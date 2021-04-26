package interfaces;

import player.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileHandling {

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
