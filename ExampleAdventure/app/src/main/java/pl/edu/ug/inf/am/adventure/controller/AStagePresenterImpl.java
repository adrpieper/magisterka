package pl.edu.ug.inf.am.adventure.controller;

import pl.edu.ug.inf.am.adventure.AStagePresenter;
import pl.edu.ug.inf.am.adventure.view.WinFragment;
import pl.edu.ug.inf.am.adventure.view.FightFragment;
import pl.edu.ug.inf.am.adventure.view.QuestionFragment;
import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.view.FragmentDisplayer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AStagePresenterImpl implements AStagePresenter {

    private final DiComponent diComponent;
    private final FragmentDisplayer fragmentDisplayer;

    @Inject
    public AStagePresenterImpl(DiComponent diComponent, FragmentDisplayer fragmentDisplayer) {
        this.diComponent = diComponent;
        this.fragmentDisplayer = fragmentDisplayer;
    }

    @Override
    public void showWin() {
        WinFragment winFragment = new WinFragment();
        diComponent.inject(winFragment);
        fragmentDisplayer.showFragment(winFragment);
    }

    @Override
    public void showQuestion() {
        QuestionFragment questionFragment = new QuestionFragment();
        diComponent.inject(questionFragment);
        fragmentDisplayer.showFragment(questionFragment);
    }

    @Override
    public void showFight() {
        FightFragment fightFragment = new FightFragment();
        diComponent.inject(fightFragment);
        fragmentDisplayer.showFragment(fightFragment);
    }
}
