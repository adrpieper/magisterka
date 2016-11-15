package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PerAdventureStage
public class FightModel extends BaseObservable {

    private EnemyModel enemy;
    private final AdventurePlayerModel player;
    private FightStatus fightStatus;
    private List<MonsterType> monstersToKill = new ArrayList<>();
    private List<MonsterType> killedMonsters = new ArrayList<>();
    private MonsterType actualMonster;

    @Inject
    public FightModel(AdventurePlayerModel playerModel) {
        this.player = playerModel;
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
    public FightStatus getFightStatus() {
        return fightStatus;
    }

    public void setEnemy(EnemyModel enemy) {
        this.enemy = enemy;
        notifyPropertyChanged(BR.enemy);
    }

    public void setFightStatus(FightStatus fightStatus) {
        this.fightStatus = fightStatus;
        notifyPropertyChanged(BR.result);
    }

    public void setMonstersToKill(List<MonsterType> monstersToKill) {
        this.monstersToKill.clear();
        this.monstersToKill = new ArrayList<>(monstersToKill);
        MonsterType actualMonster = monstersToKill.get(0);
        setActualMonster(actualMonster);
        fightStatus = FightStatus.FIGHT;
    }

    public void killActualMonster() {
        monstersToKill.remove(actualMonster);
        killedMonsters.add(actualMonster);
        if (hasMoreMonstersToKill()) {
            setFightStatus(FightStatus.ENEMY_KILLED);
        }else {
            setFightStatus(FightStatus.WIN);
        }
    }

    public void nextMonster() {
        MonsterType nextMonster = monstersToKill.get(0);
        setActualMonster(nextMonster);
        setFightStatus(FightStatus.FIGHT);
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
            setFightStatus(FightStatus.LOST);
        }
    }

    private void setActualMonster(MonsterType actualMonster) {
        this.actualMonster = actualMonster;
        setEnemy(new EnemyModel(actualMonster));
    }

    public List<MonsterType> getKilledMonsters() {
        return killedMonsters;
    }


}
