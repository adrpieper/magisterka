package pl.edu.ug.inf.am.adventure.fight.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.edu.ug.inf.am.adventure.fight.controller.FightController;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.FightFragmentBinding;

import javax.inject.Inject;

public class FightFragment extends Fragment {

    @Inject
    FightController fightController;

    public FightFragment() {
        App.getComponent(FightComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FightModel fightModel = fightController.createFightModel();

        FightFragmentBinding binding = FightFragmentBinding.inflate(inflater);
        binding.setFight(fightModel);

        binding.attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fightModel.getResult() == FightState.Result.FIGHT){
                    fightController.fight(fightModel);
                } else {
                    fightController.nextEnemy(fightModel);
                }
            }
        });

        return binding.getRoot();
    }
}
