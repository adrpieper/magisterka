package pl.edu.ug.inf.am.adventure;

import pl.edu.ug.inf.am.adventure.state.AStageState;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.adventure.state.QuestionState;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.view.StageViewManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdventureViewManager implements StageViewManager<AdventureState> {

    private final AStagePresenter aStagePresenter;

    @Inject
    public AdventureViewManager(AStagePresenter aStagePresenter) {
        this.aStagePresenter = aStagePresenter;
    }

    @Override
    public void showState(AdventureState state, GameActivity gameActivity) {
        AStageState adventureState = state.getState();
        if (adventureState instanceof FightState){
            showFightState((FightState) adventureState);
        }
        else if (adventureState instanceof QuestionState){
            aStagePresenter.showQuestion();
        }
    }

    private void showFightState(FightState fightState) {
        if (fightState.getResult().isEnd()) {
            aStagePresenter.showWin();
        }else {
            aStagePresenter.showFight();
        }
    }
}
