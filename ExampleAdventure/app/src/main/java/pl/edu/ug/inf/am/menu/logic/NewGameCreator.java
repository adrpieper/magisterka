package pl.edu.ug.inf.am.menu.logic;

import pl.aml.character.CharacterType;
import pl.edu.ug.inf.am.app.dagger.AppSubComponentManager;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;
import pl.edu.ug.inf.am.menu.state.GameStateDTO;
import pl.edu.ug.inf.am.game.state.PlayerState;

import javax.inject.Inject;

@PerMenu
public class NewGameCreator {

    private final PlayerStateFactory playerStateFactory;
    private final AvailableAdventuresCreator availableAdventuresCreator;
    private final AppSubComponentManager appSubComponentManager;

    @Inject
    public NewGameCreator(PlayerStateFactory playerStateFactory, AvailableAdventuresCreator availableAdventuresCreator, AppSubComponentManager appSubComponentManager) {
        this.playerStateFactory = playerStateFactory;
        this.availableAdventuresCreator = availableAdventuresCreator;
        this.appSubComponentManager = appSubComponentManager;
    }

    public void startNew(CharacterType characterType) {

        PlayerState playerState = playerStateFactory.createNew(characterType);
        AvailableAdventures adventures = availableAdventuresCreator.create();
        GameStateDTO gameStateDTO = new GameStateDTO(playerState, adventures);
        appSubComponentManager.startGame(gameStateDTO);
    }
}

