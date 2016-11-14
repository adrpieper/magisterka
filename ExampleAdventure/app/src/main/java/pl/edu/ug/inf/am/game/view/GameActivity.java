package pl.edu.ug.inf.am.game.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import pl.edu.ug.inf.am.R;

public class GameActivity extends Activity {

    private static final String CENTER_FRAGMENT_TAG = "C_F_T";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
    }

    public void showFragment(Fragment gameFragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center_fragment, gameFragment, CENTER_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

}
