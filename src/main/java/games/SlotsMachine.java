package games;

import player.Player;

public class SlotsMachine implements Game{

    private Player registeredPlayer;

    public SlotsMachine(){

    }

    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }
}
