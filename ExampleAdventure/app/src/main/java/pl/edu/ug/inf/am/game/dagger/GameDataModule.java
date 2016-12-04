package pl.edu.ug.inf.am.game.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.menu.state.GameStateDTO;
import pl.edu.ug.inf.am.game.state.PlayerState;

@Module
public class GameDataModule {

    private final PlayerState playerState;
    private final AvailableAdventures availableAdventures;


    public GameDataModule(GameStateDTO gameStateDTO) {
        playerState = gameStateDTO.getPlayerState();
        availableAdventures = gameStateDTO.getAvailableAdventures();
    }

    @PerGame
    @Provides
    public PlayerState providePlayerState() {
        return playerState;
    }

    @PerGame
    @Provides
    public AvailableAdventures provideAvailableAdventures() {
        return availableAdventures;
    }
}
