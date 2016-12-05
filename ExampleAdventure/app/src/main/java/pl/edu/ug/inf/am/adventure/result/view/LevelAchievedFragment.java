package pl.edu.ug.inf.am.adventure.result.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.adventure.result.controller.AdventureResultController;
import pl.edu.ug.inf.am.adventure.result.dagger.AdventureResultComponent;
import pl.edu.ug.inf.am.adventure.state.AdventureResult;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.LevelAchievedFragmentBinding;

import javax.inject.Inject;
public class LevelAchievedFragment extends Fragment{

    @Inject
    AdventureResult adventureResult;

    @Inject
    AdventureResultController controller;

    public LevelAchievedFragment() {
        App.getComponent(AdventureResultComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        LevelAchievedFragmentBinding binding = LevelAchievedFragmentBinding.inflate(inflater);
        binding.setResult(adventureResult);
        binding.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.acceptLevelAchieved();
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
