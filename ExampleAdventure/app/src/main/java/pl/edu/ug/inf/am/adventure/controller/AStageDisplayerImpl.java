package pl.edu.ug.inf.am.adventure.controller;

import pl.aml.AFight;
import pl.aml.AStageDisplayer;
import pl.aml.End;
import pl.aml.Question;
import pl.edu.ug.inf.am.adventure.WinFragment;
import pl.edu.ug.inf.am.adventure.view.FightFragment;
import pl.edu.ug.inf.am.adventure.view.QuestionFragment;
import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.view.FragmentDisplayer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AStageDisplayerImpl implements AStageDisplayer {

    private final DiComponent diComponent;
    private final FragmentDisplayer fragmentDisplayer;

    @Inject
    public AStageDisplayerImpl(DiComponent diComponent, FragmentDisplayer fragmentDisplayer) {
        this.diComponent = diComponent;
        this.fragmentDisplayer = fragmentDisplayer;
    }

    @Override
    public void show(AFight aFight) {

        FightFragment fightFragment = new FightFragment();
        diComponent.inject(fightFragment);
        fragmentDisplayer.showFragment(fightFragment);
    }

    @Override
    public void show(End end) {
        WinFragment winFragment = new WinFragment();
        diComponent.inject(winFragment);
        fragmentDisplayer.showFragment(winFragment);
    }

    @Override
    public void show(Question question) {
        QuestionFragment questionFragment = new QuestionFragment();
        diComponent.inject(questionFragment);
        fragmentDisplayer.showFragment(questionFragment);
    }
}
