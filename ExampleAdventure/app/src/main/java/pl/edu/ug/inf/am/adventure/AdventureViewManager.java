package pl.edu.ug.inf.am.adventure;

import pl.aml.AStageDisplayer;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.view.StageViewManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdventureViewManager implements StageViewManager<AdventureState> {

    private final AStageDisplayer aStageDisplayer;

    @Inject
    public AdventureViewManager(AStageDisplayer aStageDisplayer) {
        this.aStageDisplayer = aStageDisplayer;
    }


    @Override
    public void showState(AdventureState state, GameActivity gameActivity) {
        state.getAStage().show(aStageDisplayer);
    }
}
