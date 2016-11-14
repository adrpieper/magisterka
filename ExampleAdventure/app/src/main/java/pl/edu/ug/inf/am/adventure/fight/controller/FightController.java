package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.fight.logic.FightResultDTO;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.FightLogic;
import pl.edu.ug.inf.am.adventure.fight.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerAdventureStage
public class FightController {

    private final FightModel fightModel;
    private final FightNavigator fightNavigator;
    private final FightLogic fightLogic;

    @Inject
    public FightController(FightModel fightModel, FightNavigator fightNavigator, FightLogic fightLogic) {
        this.fightModel = fightModel;
        this.fightNavigator = fightNavigator;
        this.fightLogic = fightLogic;
    }

    public void fight() {
        fightLogic.fight();
        if (fightModel.getResult().isEnd()) {
            fightNavigator.showWin();
        }
    }

}
