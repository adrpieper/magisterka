package pl.edu.ug.inf.am.adventure;

import pl.aml.*;
import pl.edu.ug.inf.am.adventure.controller.AdventureStageStarter;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.adventure.state.QuestionState;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.stage.StageManager;

import java.util.Collection;
import java.util.List;

public class AdventureEngineImpl implements AdventureEngine {

    private final AdventureStateManager adventureStateManager;
    private final AdventureStageStarter adventureStageStarter;
    private final AStagePresenter aStagePresenter;
    private final StageManager stageManager;

    public AdventureEngineImpl(AdventureStateManager adventureStateManager, AdventureStageStarter adventureStageStarter, AStagePresenter aStagePresenter, StageManager stageManager) {
        this.adventureStateManager = adventureStateManager;
        this.adventureStageStarter = adventureStageStarter;
        this.aStagePresenter = aStagePresenter;
        this.stageManager = stageManager;
    }


    @Override
    public void fight(Collection<MonsterType> opponents) {
        final FightState state = new FightState(opponents);
        final MonsterType actualMonster = state.getMonstersToKill().get(0);
        state.setActualMonster(actualMonster);
        state.setEnemyHealth(actualMonster.getHp());
        adventureStateManager.setState(state);
        aStagePresenter.showFight();
    }

    @Override
    public void end() {
        if (adventureStateManager.getStagesStack().isEmpty()) {
            stageManager.changeStage(GameStage.TRIP, null);
        }
        else {
            runFirstOnStack();
        }
    }

    @Override
    public void addStages(List<AStage> stages) {
        adventureStateManager.addStages(stages);
        runFirstOnStack();
    }

    @Override
    public void ask(String question, Collection<QuestionAnswer> answers) {
        adventureStateManager.setState(new QuestionState(question,answers));
        aStagePresenter.showQuestion();
    }

    private void runFirstOnStack() {
        adventureStateManager.getStagesStack().pop().run(this);
    }

}
