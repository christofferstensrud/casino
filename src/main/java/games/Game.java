package games;

import player.Player;

public interface Game {

    Player getRegisteredPlayer();
    void setRegisteredPlayer(final Player registeredPlayer);

}
