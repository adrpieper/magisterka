package pl.edu.ug.inf.am.adventure.fight.view;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import pl.edu.ug.inf.am.adventure.fight.controller.FightController;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.model.FightConsoleModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.FightFragmentBinding;

import javax.inject.Inject;

public class FightFragment extends Fragment {

    @Inject
    FightController fightController;
    @Inject
    FightConsoleModel consoleModel;
    @Inject
    FightModel fightModel;
    private Button attackButton;

    public FightFragment() {
        App.getComponent(FightComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FightFragmentBinding binding = FightFragmentBinding.inflate(inflater);
        binding.setFight(fightModel);
        binding.setConsole(consoleModel);
        attackButton = binding.attackButton;
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fightModel.getFightStatus() == FightStatus.FIGHT){
                    fight();
                } else {
                    fightController.nextOpponent();
                }
            }
        });

        return binding.getRoot();
    }

    private void fight() {
        fightController.playerAttack();
        attackButton.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fightController.enemyAttack();
                attackButton.setEnabled(true);
            }
        }, 1000);
    }
}
