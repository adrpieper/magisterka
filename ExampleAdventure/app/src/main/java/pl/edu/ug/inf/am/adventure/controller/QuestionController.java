package pl.edu.ug.inf.am.adventure.controller;

import pl.aml.Question;
import pl.aml.QuestionAnswer;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuestionController {

    private final AdventureStageStarter adventureStageStarter;
    private final AdventureStateManager stateManager;

    @Inject
    public QuestionController(AdventureStageStarter adventureStageStarter, AdventureStateManager stateManager) {
        this.adventureStageStarter = adventureStageStarter;
        this.stateManager = stateManager;
    }

    public void answer(QuestionAnswer questionAnswer){
        adventureStageStarter.start(questionAnswer.getAStage());
    }

    public Question getQuestion(){
        return stateManager.getStage();
    }
}
