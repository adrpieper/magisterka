package pl.edu.ug.inf.am.app.dagger;

import pl.aml.character.CharacterType;
import pl.aml.impl.character.ExampleCharacterTypeFactory;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.dagger.GameDataModule;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.menu.state.GameStateDTO;

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
        GameStateDTO gameStateDTO = appComponent.menuComponent().newGameCreator().createNew(characterType);
        startGame(gameStateDTO);
    }

    private void startGame(GameStateDTO gameStateDTO) {
        GameDataModule gameDataModule = new GameDataModule(gameStateDTO);
        gameComponent = appComponent.gameComponent(gameDataModule);
        setSubcomponent(GameComponent.class, gameComponent);
    }

    public void runGame(GameActivity gameActivity) {
        gameComponent.gameViewContainer().bindActivity(gameActivity);
        gameComponent.gameInitializer().init();
    }
}
