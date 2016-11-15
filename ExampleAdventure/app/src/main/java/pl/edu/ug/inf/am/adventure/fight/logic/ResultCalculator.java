package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.ItemType;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;
import pl.edu.ug.inf.am.adventure.fight.state.Result;
import pl.edu.ug.inf.am.adventure.fight.state.ResultDTO;

import javax.inject.Inject;
import java.util.Collections;
@PerAdventureStage
public class ResultCalculator {

    private final FightModel fightModel;

    @Inject
    public ResultCalculator(FightModel fightModel) {
        this.fightModel = fightModel;
    }

    public ResultDTO calculateResult() {
        if (fightModel.getFightStatus() == FightStatus.WIN) {
            return calulateForWin();
        }
        else {
            return calulateForLost();
        }

    }

    private ResultDTO calulateForLost() {
        return new ResultDTO(Result.LOST, 0, Collections.<ItemType>emptyList());
    }

    private ResultDTO calulateForWin() {

        int exp = 0;
        for (MonsterType monsterType : fightModel.getKilledMonsters()) {
            exp += monsterType.getExp();
        }

        return new ResultDTO(Result.WIN, exp, Collections.<ItemType>emptyList());
    }
}
