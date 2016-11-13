package pl.edu.ug.inf.am.game.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.game.view.GameView;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.game.view.GameViewContainer;

@Module
public class GameViewModule {

    @Provides
    @PerGame
    public GameView provideGameView(GameViewContainer container) {
        return container;
    }
}
