package pl.edu.ug.inf.am.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;

public class GameActivity extends Activity {

    @Inject
    GameStateManager gameStateManager;

    @Inject
    ViewManage viewManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewManage.show(gameStateManager.getGameState());
    }

    public void showFragment(Fragment gameFragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center_fragment, gameFragment);
        fragmentTransaction.commit();
    }
}
