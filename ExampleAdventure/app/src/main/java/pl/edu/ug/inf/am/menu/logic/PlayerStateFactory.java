package pl.edu.ug.inf.am.menu.logic;

import pl.aml.character.CharacterType;
import pl.aml.character.SkillType;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;
import pl.edu.ug.inf.am.game.state.PlayerState;

import javax.inject.Inject;
import java.util.EnumSet;

@PerMenu
public class PlayerStateFactory {

    @Inject
    public PlayerStateFactory() {
    }

    public PlayerState createNew(CharacterType characterType) {

        PlayerState playerState = new PlayerState(characterType);

        playerState.setStats(characterType.getStatsOnStart());
        playerState.setSkills(EnumSet.of(SkillType.BASIC_HIT));
        playerState.setSkillPoints(1);
        return playerState;
    }
}
