package pl.edu.ug.inf.am.adventure.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.adventure.FightResultDTO;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.model.PlayerModel;

public class FightModel extends BaseObservable {

    private EnemyModel enemy;
    private final PlayerModel player;
    private FightState.Result result;

    public FightModel(EnemyModel enemy, PlayerModel playerModel, FightState.Result result) {
        this.enemy = enemy;
        this.player = playerModel;
        this.result = result;
    }

    @Bindable
    public PlayerModel getPlayer() {
        return player;
    }

    @Bindable
    public EnemyModel getEnemy() {
        return enemy;
    }

    @Bindable
    public FightState.Result getResult() {
        return result;
    }

    public void setEnemy(EnemyModel enemy) {
        this.enemy = enemy;
        notifyPropertyChanged(BR.enemy);
    }

    public void setResult(FightState.Result result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

}
