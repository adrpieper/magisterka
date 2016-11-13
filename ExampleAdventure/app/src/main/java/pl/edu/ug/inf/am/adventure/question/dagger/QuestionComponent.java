package pl.edu.ug.inf.am.adventure.question.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.question.stage.QuestionStage;
import pl.edu.ug.inf.am.adventure.question.view.QuestionFragment;

@PerAdventureStage
@Subcomponent(modules = QuestionModule.class)
public interface QuestionComponent {

    QuestionStage questionLifecycleCallbacks();
    void inject(QuestionFragment questionFragment);
}
