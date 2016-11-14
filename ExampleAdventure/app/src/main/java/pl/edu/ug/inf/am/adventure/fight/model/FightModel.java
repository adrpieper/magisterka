package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;
import pl.edu.ug.inf.am.player.model.PlayerModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PerAdventureStage
public class FightModel extends BaseObservable {

    private EnemyModel enemy;
    private final AdventurePlayerModel player;
    private FightState.Result result;
    private List<MonsterType> monstersToKill = new ArrayList<>();
    private List<MonsterType> killedMonsters = new ArrayList<>();
    private MonsterType actualMonster;

    @Inject
    public FightModel(EnemyModel enemy, AdventurePlayerModel playerModel, FightState.Result result) {
        this.enemy = enemy;
        this.player = playerModel;
        this.result = result;
    }

    @Bindable
    public AdventurePlayerModel getPlayer() {
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

    public void setMonstersToKill(List<MonsterType> monstersToKill) {
        this.monstersToKill.clear();
        this.monstersToKill = new ArrayList<>(monstersToKill);
        MonsterType actualMonster = monstersToKill.get(0);
        setActualMonster(actualMonster);
        result = FightState.Result.FIGHT;
    }

    public void killActualMonster() {
        monstersToKill.remove(actualMonster);
        killedMonsters.add(actualMonster);
        if (hasMoreMonstersToKill()) {
            setResult(FightState.Result.ENEMY_KILLED);
        }else {
            setResult(FightState.Result.WIN);
        }
    }

    public void nextMonster() {
        MonsterType nextMonster = monstersToKill.get(0);
        setActualMonster(nextMonster);
        setResult(FightState.Result.FIGHT);
    }

    public boolean hasMoreMonstersToKill() {
        return !monstersToKill.isEmpty();
    }

    public void showFightResult(int enemyHp, int playerHp) {
        if (enemyHp == 0){
            killActualMonster();
        }

        enemy.setHp(enemyHp);
        player.setHp(playerHp);

        if (playerHp == 0){
            setResult(FightState.Result.LOST);
        }
    }

    private void setActualMonster(MonsterType actualMonster) {
        this.actualMonster = actualMonster;
        setEnemy(new EnemyModel(actualMonster));
    }
}
