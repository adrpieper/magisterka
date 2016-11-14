package pl.edu.ug.inf.am.game.view;

import android.app.Fragment;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;
import java.lang.ref.WeakReference;

@PerGame
public class GameViewContainer implements GameView {

    private WeakReference<GameActivity> gameActivity;

    @Inject
    public GameViewContainer() {
    }

    public void bindActivity(GameActivity gameActivity) {
        this.gameActivity = new WeakReference<GameActivity>(gameActivity);
    }

    @Override
    public void showFragment(Fragment gameFragment) {
        gameActivity.get().showFragment(gameFragment);
    }


}
