package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.aml.AdventureEngine;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.ResultModel;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerAdventureStage
public class ResultAccepter {

    private final FightState fightState;
    private final PlayerState playerState;
    private final AdventureEngine adventureEngine;

    @Inject
    public ResultAccepter(FightState fightState, PlayerState playerState, AdventureEngine adventureEngine) {
        this.fightState = fightState;
        this.playerState = playerState;
        this.adventureEngine = adventureEngine;
    }


    public ResultModel createResultModel() {
        int exp = 0;
        for (MonsterType monster : fightState.getKilledMonsters()) {
            exp += monster.getExp();
        }
        return new ResultModel(exp);
    }

    public void acceptResult(ResultModel result) {
        int actualExp = playerState.getExperience();
        playerState.setExperience(actualExp + result.getGainedExp());
        adventureEngine.end();
    }
}
