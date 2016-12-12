package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.gps.view.GPSSwitch;

public class GPSFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return new GPSSwitch(getActivity());
    }
}
