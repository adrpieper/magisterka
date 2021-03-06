package pl.edu.ug.inf.am.adventure.question.controller;

import pl.aml.adventure.AdventureEngine;
import pl.aml.adventure.QuestionAnswer;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;

import javax.inject.Inject;

@PerAdventureStage
public class QuestionController {

    private final AdventureEngine engine;
    private final QuestionState questionState;

    @Inject
    public QuestionController(AdventureEngine engine, QuestionState questionState) {
        this.engine = engine;
        this.questionState = questionState;
    }

    public void answer(QuestionAnswer questionAnswer){
        questionAnswer.getAStage().run(engine);
    }

    public QuestionState getQuestion(){
        return questionState;
    }
}
