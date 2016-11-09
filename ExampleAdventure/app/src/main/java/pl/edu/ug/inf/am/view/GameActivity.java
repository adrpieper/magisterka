package pl.edu.ug.inf.am.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.app.dagger.DaggerDiComponent;
import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.app.dagger.GameViewModule;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;

public class GameActivity extends Activity implements FragmentDisplayer {

    private DiComponent diComponent;

    @Inject
    GameStateManager gameStateManager;

    @Inject
    MainController mainController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        diComponent = DaggerDiComponent.builder().gameViewModule(new GameViewModule(this)).build();
        diComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainController.show(gameStateManager.getGameState());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        diComponent = null;
    }

    @Override
    public void showFragment(Fragment gameFragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center_fragment, gameFragment);
        fragmentTransaction.commit();
    }
}
