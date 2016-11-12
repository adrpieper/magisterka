package pl.edu.ug.inf.am.adventure;

import pl.aml.End;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.controller.AdventureStageStarter;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;
import pl.edu.ug.inf.am.adventure.model.ResultModel;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ResultAccepter {

    private final AdventureStateManager adventureStateManager;
    private final AdventureStageStarter adventureStageStarter;

    @Inject
    public ResultAccepter(AdventureStateManager adventureStateManager, AdventureStageStarter adventureStageStarter) {
        this.adventureStateManager = adventureStateManager;
        this.adventureStageStarter = adventureStageStarter;
    }

    public ResultModel createResultModel() {
        final FightState fightState = adventureStateManager.getState();
        int exp = 0;
        for (MonsterType monster : fightState.getKilledMonsters()) {
            exp += monster.getExp();
        }
        return new ResultModel(exp);
    }

    public void acceptResult(ResultModel result) {
        final PlayerState playerState = adventureStateManager.getPlayerState();
        int actualExp = playerState.getExperience();
        playerState.setExperience(actualExp + result.getGainedExp());
        adventureStageStarter.start(new End());;
    }
}
