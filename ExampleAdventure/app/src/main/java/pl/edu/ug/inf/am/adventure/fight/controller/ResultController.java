package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.ResultCalculator;
import pl.edu.ug.inf.am.adventure.fight.state.Result;
import pl.edu.ug.inf.am.adventure.fight.state.ResultDTO;
import pl.edu.ug.inf.am.adventure.state.AdventureResult;

import javax.inject.Inject;

@PerAdventureStage
public class ResultController {

    private ResultDTO resultDTO;
    private final ResultCalculator fightModel;
    private final AdventureResult adventureResult;
    private final FightNavigator fightNavigator;

    @Inject
    public ResultController(ResultCalculator fightModel, AdventureResult adventureResult, FightNavigator fightNavigator) {
        this.fightModel = fightModel;
        this.adventureResult = adventureResult;
        this.fightNavigator = fightNavigator;
    }

    public ResultDTO getResultDTO() {
        return resultDTO;
    }

    public void acceptResult() {
        if (resultDTO.getResult() == Result.WIN) {
            fightNavigator.goToWinStage();
        }else {
            fightNavigator.goToLostStage();
        }
    }

    public void calculateAndShowResult() {
        resultDTO = fightModel.calculateResult();
        adventureResult.addExperience(resultDTO.getGainedExp());
        fightNavigator.showResult();
    }
}
