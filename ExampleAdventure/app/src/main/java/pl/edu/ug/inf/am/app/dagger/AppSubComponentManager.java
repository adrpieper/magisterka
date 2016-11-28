package pl.edu.ug.inf.am.app.dagger;

import pl.aml.character.CharacterType;
import pl.aml.character.ExampleCharacterTypeFactory;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.dagger.GameDataModule;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerApp
public class AppSubComponentManager extends SubComponentManager {

    private final AppComponent appComponent;
    private GameComponent gameComponent = null;

    @Inject
    public AppSubComponentManager(ComponentsManager componentsManager, AppComponent appComponent) {
        super(componentsManager);
        this.appComponent = appComponent;
    }

    public void prepareNewGame(){
        CharacterType characterType = new ExampleCharacterTypeFactory().create();
        PlayerState playerState = appComponent.menuComponent().playerStateFactory().createNew(characterType);
        GameDataModule gameDataModule = new GameDataModule(playerState);
        gameComponent = appComponent.gameComponent(gameDataModule);
        setSubcomponent(GameComponent.class, gameComponent);
    }

    public void runGame(GameActivity gameActivity) {
        gameComponent.gameViewContainer().bindActivity(gameActivity);
        gameComponent.gameInitializer().init();
    }
}
