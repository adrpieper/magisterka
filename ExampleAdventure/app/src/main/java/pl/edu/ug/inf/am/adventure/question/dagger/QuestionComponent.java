package pl.edu.ug.inf.am.adventure.question.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.question.view.QuestionFragment;
import pl.edu.ug.inf.am.game.view.GameView;

@PerAdventureStage
@Subcomponent(modules = QuestionModule.class)
public interface QuestionComponent {

    GameView gameView();
    void inject(QuestionFragment questionFragment);
}
