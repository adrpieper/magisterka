package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.databinding.PlayerReviewFragmentBinding;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;

import javax.inject.Inject;

public class PlayerReviewFragment extends Fragment {

    @Inject
    PlayerState playerState;

    public PlayerReviewFragment() {
        App.getComponent(TripComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final PlayerReviewFragmentBinding binder = PlayerReviewFragmentBinding.inflate(inflater);
        binder.setPlayer(new PlayerModel(playerState));
        return binder.getRoot();
    }
}
