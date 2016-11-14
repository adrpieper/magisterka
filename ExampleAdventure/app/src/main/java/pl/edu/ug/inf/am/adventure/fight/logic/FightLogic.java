package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightLogic {

    private FightModel fightModel;

    @Inject
    public FightLogic(FightModel fightModel) {
        this.fightModel = fightModel;
    }

    public void fight(){

        int enemyHp = 0;
        int playerHp = 100;

        fightModel.showFightResult(enemyHp, playerHp);
    }
}
