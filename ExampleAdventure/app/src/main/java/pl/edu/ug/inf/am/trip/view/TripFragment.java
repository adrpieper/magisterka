package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.databinding.TripFragmentBinding;

import javax.inject.Inject;

public class TripFragment extends Fragment{

    @Inject
    TripNavigator tripNavigator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        TripFragmentBinding binding = TripFragmentBinding.inflate(inflater);
        binding.showPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tripNavigator.showPlayer();
            }
        });
        binding.showLocationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tripNavigator.showLocations();
            }
        });
        return binding.getRoot();
    }
}
