package pl.edu.ug.inf.am.adventure.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.adventure.FightController;
import pl.edu.ug.inf.am.adventure.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.model.FightModel;
import pl.edu.ug.inf.am.databinding.EnemyViewBinding;
import pl.edu.ug.inf.am.databinding.PlayerViewBinding;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.view.GameFragment;

import javax.inject.Inject;

public class FightFragment extends GameFragment{

    @Inject
    FightController adventureModelModule;
    private FightModel fightModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fight_fragment, container, false);
        fightModel = adventureModelModule.createFightModel();

        final EnemyModel enemy = fightModel.getEnemyModel();
        final View enemyView = view.findViewById(R.id.enemy_view);
        final EnemyViewBinding bind = EnemyViewBinding.bind(enemyView);
        bind.setEnemy(enemy);

        PlayerViewBinding playerBind = PlayerViewBinding.bind(view.findViewById(R.id.player_view));
        final PlayerModel player = fightModel.getPlayerModel();
        playerBind.setPlayer(player);


        Button attackButton = (Button) view.findViewById(R.id.attack_button);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adventureModelModule.fight(fightModel);
            }
        });

        return view;
    }
}
