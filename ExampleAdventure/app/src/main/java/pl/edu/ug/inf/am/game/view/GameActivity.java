package pl.edu.ug.inf.am.game.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.nfc.NFC;

import javax.inject.Inject;

public class GameActivity extends Activity {

    private static final String CENTER_FRAGMENT_TAG = "C_F_T";

    @Inject
    NFC nfc;

    public GameActivity() {
        App.getComponent(GameComponent.class).inject(this);
    }

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

    @Override
    protected void onResume() {
        super.onResume();
        nfc.start(this);
    }

    @Override
    protected void onPause() {
        nfc.stop(this);
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        nfc.handleIntent(intent);
    }
}
