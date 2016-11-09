package pl.edu.ug.inf.am.adventure.controller;

import pl.aml.Question;
import pl.aml.QuestionAnswer;
import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.adventure.state.AdventureState;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuestionController {

    private final AdventureStageStarter adventureStageStarter;
    private final GameStageStateProvider stateProvider;

    @Inject
    public QuestionController(AdventureStageStarter adventureStageStarter, GameStageStateProvider stateProvider) {
        this.adventureStageStarter = adventureStageStarter;
        this.stateProvider = stateProvider;
    }

    public void answer(QuestionAnswer questionAnswer){
        adventureStageStarter.start(questionAnswer.getAStage());
    }

    public Question getQuestion(){
        return stateProvider.getAdventureState().getAStage();
    }
}
