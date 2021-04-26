package interfaces;

import player.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileHandling {

    /**
     * @return the state of the player.
     */
    Player readPlayerState(String filePath) throws IOException;

    /**
     * Prints the state of a player.
     *
     * @param player the player to print to file.
     */
    boolean printPlayerState(Player player);


}