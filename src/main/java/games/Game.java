package games;

import player.Player;

public interface Game {

    /**
     * @return the player registered to this Game.
     */
    Player getRegisteredPlayer();

    /**
     * Registers the player to this Game.
     *
     * @param player the player to register.
     */
    void setRegisteredPlayer(final Player player);

}
