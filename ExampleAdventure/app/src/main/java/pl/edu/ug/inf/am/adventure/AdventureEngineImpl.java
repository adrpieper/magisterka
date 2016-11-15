package pl.edu.ug.inf.am.adventure;

import pl.aml.*;
import pl.edu.ug.inf.am.adventure.dagger.AdventureSubComponentManager;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;

import java.util.List;

public class AdventureEngineImpl implements AdventureEngine {

    private final AdventureState adventureState;
    private final AdventureSubComponentManager adventureStagesManager;
    private final AContext aContext;

    public AdventureEngineImpl(AdventureState adventureState, AdventureSubComponentManager adventureStagesManager, AContext aContext) {
        this.adventureState = adventureState;
        this.adventureStagesManager = adventureStagesManager;
        this.aContext = aContext;
    }


    @Override
    public void fight(List<MonsterType> opponents, AStage doOnWin, AStage doOnLost) {
        adventureStagesManager.startFight(opponents);
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

    @Override
    public boolean check(APredicate predicate) {
        return predicate.isTrue(aContext);
    }

    private void runFirstOnStack() {
        adventureState.popFirstStage().run(this);
    }

}
