package interfaces;

import player.Player;

public interface GameInterface {

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
