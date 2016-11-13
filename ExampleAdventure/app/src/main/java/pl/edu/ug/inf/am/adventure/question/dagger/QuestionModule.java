package pl.edu.ug.inf.am.adventure.question.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;

@Module
public class QuestionModule {
    private final QuestionState questionState;

    public QuestionModule(QuestionState questionState) {
        this.questionState = questionState;
    }

    @Provides
    @PerAdventureStage
    public QuestionState questionState() {
        return questionState;
    }
}
