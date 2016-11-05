package pl.edu.ug.inf.am.adventure;

import pl.edu.ug.inf.am.adventure.view.AdventureFragment;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.view.StageViewManager;

import javax.inject.Inject;

/**
 * Created by Adi on 2016-11-02.
 */
public class AdventureViewManager implements StageViewManager<AdventureState> {

    private final DiComponent diComponent;
    private final GameStateManager gameStateManager;

    @Inject
    public AdventureViewManager(DiComponent diComponent, GameStateManager gameStateManager) {
        this.diComponent = diComponent;
        this.gameStateManager = gameStateManager;
    }

    @Override
    public void showState(AdventureState state, GameActivity gameActivity) {

        if (state.isEnd()) {
            WinFragment winFragment = new WinFragment();
            diComponent.inject(winFragment);
            gameActivity.showFragment(winFragment);
        }else {
            AdventureFragment adventureFragment = new AdventureFragment();
            diComponent.inject(adventureFragment);
            gameActivity.showFragment(adventureFragment);
        }
    }
}
