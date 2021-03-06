package pl.edu.ug.inf.am.adventure.fight.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.fight.controller.ResultController;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.state.ResultDTO;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.FightResultViewBinding;

import javax.inject.Inject;

public class ResultFragment extends Fragment {

    @Inject
    ResultController resultController;

    public ResultFragment() {
        App.getComponent(FightComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FightResultViewBinding binding = FightResultViewBinding.inflate(inflater);
        binding.setResult(resultController.getResultDTO());
        binding.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultController.acceptResult();
            }
        });
        return binding.getRoot();
    }
}
