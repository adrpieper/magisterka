package pl.edu.ug.inf.am.app.dagger;

import pl.aml.character.CharacterType;
import pl.aml.character.CharacterTypesProvider;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.dagger.GameDataModule;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.menu.dagger.MenuComponent;
import pl.edu.ug.inf.am.menu.state.GameStateDTO;

import javax.inject.Inject;

@PerApp
public class AppSubComponentManager extends SubComponentManager {

    private final AppComponent appComponent;
    private final CharacterTypesProvider characterTypesProvider;
    private GameComponent gameComponent = null;

    @Inject
    public AppSubComponentManager(ComponentsManager componentsManager, AppComponent appComponent, CharacterTypesProvider characterTypesProvider) {
        super(componentsManager);
        this.appComponent = appComponent;
        this.characterTypesProvider = characterTypesProvider;
    }

    public void startFastGame(){
        CharacterType characterType = characterTypesProvider.provideAll().get(0);
        appComponent.menuComponent().newGameCreator().startNew(characterType);

    }

    public void startGame(GameStateDTO gameStateDTO) {
        GameDataModule gameDataModule = new GameDataModule(gameStateDTO);
        gameComponent = appComponent.gameComponent(gameDataModule);
        setSubcomponent(GameComponent.class, gameComponent);
    }

    public void runGame(GameActivity gameActivity) {
        gameComponent.gameViewContainer().bindActivity(gameActivity);
        gameComponent.gameInitializer().init();
    }

    public void startMenu() {
        setSubcomponent(MenuComponent.class, appComponent.menuComponent());
    }
}
