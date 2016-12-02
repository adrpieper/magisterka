package pl.edu.ug.inf.am.gps.view;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.gps.CantUseGPSException;
import pl.edu.ug.inf.am.gps.GPS;

import javax.inject.Inject;

public class GPSFragment extends Fragment {

    @Inject
    GPS gps;

    public GPSFragment() {
        App.getComponent(GameComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Switch aSwitch = new Switch(getActivity());
        gps.setListener(new GPS.GPSListener() {
            @Override
            public void onLocationChanged(Location location) {
                Toast.makeText(getActivity(), location.toString(), Toast.LENGTH_LONG).show();
            }
        });
        aSwitch.setChecked(gps.isRunning());
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (gps.isRunning()) {
                        gps.stop();
                    } else {
                        gps.start();
                    }
                } catch (CantUseGPSException e) {
                    Toast.makeText(getActivity(), "Can't use gps", Toast.LENGTH_SHORT).show();
                }
                aSwitch.setChecked(gps.isRunning());
            }
        });
        return aSwitch;
    }
}
