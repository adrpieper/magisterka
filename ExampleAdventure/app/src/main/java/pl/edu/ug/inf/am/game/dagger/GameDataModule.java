package pl.edu.ug.inf.am.game.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.player.state.PlayerState;

@Module
public class GameDataModule {

    private final PlayerState playerState;

    public GameDataModule(PlayerState playerState) {
        this.playerState = playerState;
    }

    @PerGame
    @Provides
    public PlayerState providePlayerState() {
        return playerState;
    }
}
