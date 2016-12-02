package pl.edu.ug.inf.am.nfc.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.nfc.NFC;

import javax.inject.Inject;

public class NFCFragment extends Fragment{

    @Inject
    NFC nfc;

    public NFCFragment() {
        App.getComponent(GameComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Switch aSwitch = new Switch(getActivity());
        aSwitch.setChecked(nfc.isRunning());
        return aSwitch;
    }

    @Override
    public void onResume() {
        super.onResume();
        nfc.stop(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        nfc.stop(getActivity());
    }
}
