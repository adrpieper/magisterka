package pl.edu.ug.inf.am.menu.state;

import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.player.state.PlayerState;

public class GameStateDTO {
    private final PlayerState playerState;
    private final AvailableAdventures availableAdventures;

    public GameStateDTO(PlayerState playerState, AvailableAdventures availableAdventures) {
        this.playerState = playerState;
        this.availableAdventures = availableAdventures;
    }

    public AvailableAdventures getAvailableAdventures() {
        return availableAdventures;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
}
