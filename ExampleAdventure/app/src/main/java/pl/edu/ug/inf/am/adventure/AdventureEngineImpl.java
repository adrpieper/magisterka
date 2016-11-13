package pl.edu.ug.inf.am.adventure;

import pl.aml.*;
import pl.edu.ug.inf.am.adventure.stage.AdventureStagesManager;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.game.stage.GameStagesManager;

import java.util.List;

public class AdventureEngineImpl implements AdventureEngine {

    private final AdventureState adventureState;
    private final AdventureStagesManager adventureStagesManager;

    public AdventureEngineImpl(AdventureState adventureState, AdventureStagesManager adventureStagesManager) {
        this.adventureState = adventureState;
        this.adventureStagesManager = adventureStagesManager;
    }


    @Override
    public void fight(List<MonsterType> opponents) {
        adventureStagesManager.startFight(new FightState(opponents));
    }

    @Override
    public void end() {
        if (adventureState.hasMoreStages()) {
            runFirstOnStack();
        }
        else {
            adventureStagesManager.endAdventure();
        }
    }

    @Override
    public void addStages(List<AStage> stages) {
        adventureState.addStages(stages);
        runFirstOnStack();
    }

    @Override
    public void ask(String question, List<QuestionAnswer> answers) {
        adventureStagesManager.startQuestion(new QuestionState(question,answers));
    }

    private void runFirstOnStack() {
        adventureState.popFirstStage().run(this);
    }

}
