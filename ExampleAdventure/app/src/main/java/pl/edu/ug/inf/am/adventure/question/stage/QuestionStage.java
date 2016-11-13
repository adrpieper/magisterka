package pl.edu.ug.inf.am.adventure.question.stage;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.view.QuestionFragment;
import pl.edu.ug.inf.am.common.StageLifecycle;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;

@PerAdventureStage
public class QuestionStage implements StageLifecycle<Void> {

    private final QuestionComponent questionComponent;
    private final GameView gameView;

    @Inject
    public QuestionStage(QuestionComponent questionComponent, GameView gameView) {
        this.questionComponent = questionComponent;
        this.gameView = gameView;
    }

    @Override
    public void onStart(Void aVoid) {
        QuestionFragment questionFragment = new QuestionFragment();
        questionComponent.inject(questionFragment);
        gameView.showFragment(questionFragment);
    }

    @Override
    public void onResume() {
        QuestionFragment questionFragment = new QuestionFragment();
        questionComponent.inject(questionFragment);
        gameView.showFragment(questionFragment);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onEnd() {

    }
}
