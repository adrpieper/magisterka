package pl.edu.ug.inf.am.menu.logic;

import pl.aml.character.CharacterType;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;
import pl.edu.ug.inf.am.menu.state.GameStateDTO;
import pl.edu.ug.inf.am.game.state.PlayerState;

import javax.inject.Inject;

@PerMenu
public class NewGameCreator {

    private final PlayerStateFactory playerStateFactory;
    private final AvailableAdventuresCreator availableAdventuresCreator;

    @Inject
    public NewGameCreator(PlayerStateFactory playerStateFactory, AvailableAdventuresCreator availableAdventuresCreator) {
        this.playerStateFactory = playerStateFactory;
        this.availableAdventuresCreator = availableAdventuresCreator;
    }

    public GameStateDTO createNew(CharacterType characterType) {

        PlayerState playerState = playerStateFactory.createNew(characterType);
        AvailableAdventures adventures = availableAdventuresCreator.create();
        return new GameStateDTO(playerState, adventures);
    }
}

