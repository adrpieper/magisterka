package pl.edu.ug.inf.am.nfc.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.nfc.NFC;

import javax.inject.Inject;

public class NFCFragment extends Switch{

    @Inject
    NFC nfc;

    public NFCFragment(Context context) {
        super(context);
        init();
    }

    public NFCFragment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        App.getComponent(GameComponent.class).inject(this);
        setChecked(nfc.isRunning());
    }
}
