package pl.edu.ug.inf.am.adventure;

import com.google.common.collect.Lists;
import pl.aml.*;
import pl.aml.adventure.*;
import pl.aml.adventure.factory.AdventureInstance;
import pl.edu.ug.inf.am.adventure.dagger.AdventureSubComponentManager;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;

import java.util.Collections;
import java.util.List;

public class AdventureEngineImpl implements AdventureEngine {

    private final AdventureState adventureState;
    private final AdventuresManager adventuresManager;
    private final AdventureSubComponentManager adventureStagesManager;
    private final AContext aContext;

    public AdventureEngineImpl(AdventureState adventureState, AdventuresManager adventuresManager, AdventureSubComponentManager adventureStagesManager, AContext aContext) {
        this.adventureState = adventureState;
        this.adventuresManager = adventuresManager;
        this.adventureStagesManager = adventureStagesManager;
        this.aContext = aContext;
    }


    @Override
    public void fight(List<MonsterType> opponents, AStage doOnWin, AStage doOnLost) {
        adventureStagesManager.startFight(opponents, doOnWin, doOnLost);
    }

    @Override
    public void end() {
        if (adventureState.hasMoreStages()) {
            runFirstOnStack();
        }
        else {
            adventureStagesManager.showAdventureResult();
        }
    }

    @Override
    public void addStages(List<AStage> stages) {
        for (int i = stages.size()-1; i >= 0; i--) {
            adventureState.addStage(stages.get(i));
        }
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

    @Override
    public void addAventure(AdventureInstance adventureInstance) {
        adventuresManager.add(adventureInstance);
    }
}
