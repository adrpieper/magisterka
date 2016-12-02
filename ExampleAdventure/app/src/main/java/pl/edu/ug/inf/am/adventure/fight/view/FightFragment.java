package pl.edu.ug.inf.am.adventure.fight.view;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import pl.adrian.bindinge.*;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.fight.controller.FightController;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.model.FightConsoleModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;
import pl.edu.ug.inf.am.adventure.fight.model.SkillModel;
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
    private ListView skillsListView;
    private final Handler handler;

    public FightFragment() {
        App.getComponent(FightComponent.class).inject(this);
        handler = new Handler();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        FightFragmentBinding binding = FightFragmentBinding.inflate(inflater);
        binding.setFight(fightModel);
        binding.setConsole(consoleModel);
        attackButton = binding.attackButton;
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            fightController.playerAttack();


            }
        });



        skillsListView = binding.skillsListView;
        Adapters.createFor(skillsListView, fightModel.getSkillsModels())
                .withListener(new AdapterBuilder.OnDataClickListener<SkillModel>() {
                    @Override
                    public void click(SkillModel object) {
                        if (object.isCanUse()){
                            fightController.useSkill(object);

                        }
                    }
                })
                .withBinding(R.layout.skill_list_item_view, BR.skillModel)
                .bind();
        return binding.getRoot();
    }



}
