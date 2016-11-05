package pl.edu.ug.inf.am.trip.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.player.PlayerStateManager;
import pl.edu.ug.inf.am.view.GameFragment;
import pl.edu.ug.inf.am.databinding.PlayerReviewFragmentBinding;

import javax.inject.Inject;

public class PlayerReviewFragment extends GameFragment{

    @Inject
    PlayerStateManager playerStateManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final PlayerReviewFragmentBinding binder = PlayerReviewFragmentBinding.inflate(inflater);
        binder.setPlayer(new PlayerModel(playerStateManager.getPlayerState()));
        return binder.getRoot();
    }
}
