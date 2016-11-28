package pl.edu.ug.inf.am.menu.logic;

import pl.aml.character.CharacterType;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerMenu
public class PlayerStateFactory {

    @Inject
    public PlayerStateFactory() {
    }

    public PlayerState createNew(CharacterType characterType) {

        PlayerState playerState = new PlayerState(characterType);

        playerState.setStats(characterType.getStatsOnStart());

        return playerState;
    }
}
