package pl.edu.ug.inf.am.adventure;

import pl.aml.impl.item.ItemType;
import pl.aml.impl.opponent.OpponentType;
import pl.aml.adventure.*;
import pl.aml.adventure.AdventureInstance;
import pl.edu.ug.inf.am.adventure.dagger.AdventureSubComponentManager;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.adventure.state.AdventureResult;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;

import java.util.List;

public class AdventureEngineImpl implements AdventureEngine {

    private final AdventureState adventureState;
    private final AdventureResult adventureResult;
    private final AvailableAdventures adventuresManager;
    private final AdventureSubComponentManager adventureStagesManager;
    private final AContext aContext;

    public AdventureEngineImpl(AdventureState adventureState, AdventureResult adventureResult, AvailableAdventures adventuresManager, AdventureSubComponentManager adventureStagesManager, AContext aContext) {
        this.adventureState = adventureState;
        this.adventureResult = adventureResult;
        this.adventuresManager = adventuresManager;
        this.adventureStagesManager = adventureStagesManager;
        this.aContext = aContext;
    }


    @Override
    public void fight(List<OpponentType> opponents, AStage doOnWin, AStage doOnLost) {
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
    public void addAdventure(AdventureInstance adventureInstance) {
        adventuresManager.add(adventureInstance);
    }

    @Override
    public void removeAdventure(AdventureInstance adventureInstance) {
        adventuresManager.remove(adventureInstance);
    }

    @Override
    public void playerGetItem(List<ItemType> items) {
        adventureResult.addItems(items);
        adventureStagesManager.showPlayerGetItem(items);
    }

    @Override
    public void showMessage(String message) {
        adventureStagesManager.showMessage(message);
    }
}
