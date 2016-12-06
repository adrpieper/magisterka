package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.opponent.OpponentType;
import pl.aml.character.SkillType;
import pl.aml.opponent.OpponentType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;
import pl.edu.ug.inf.am.trip.skills.model.SkillsModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PerAdventureStage
public class FightModel extends BaseObservable {

    private EnemyModel enemy;
    private final AdventurePlayerModel player;
    private FightStatus fightStatus;
    private List<OpponentType> monstersToKill = new ArrayList<>();
    private List<OpponentType> killedMonsters = new ArrayList<>();
    private OpponentType actualMonster;
    private List<SkillModel> skillsModels;

    @Inject
    public FightModel(AdventurePlayerModel playerModel) {
        this.player = playerModel;
        skillsModels = new ArrayList<>();
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
        notifyPropertyChanged(BR.fightStatus);
    }

    public void settOpponentsToKill(List<OpponentType> monstersToKill) {
        this.monstersToKill = new ArrayList<>(monstersToKill);
    }

    public void moveActualMonsterToKilled() {
        monstersToKill.remove(actualMonster);
        killedMonsters.add(actualMonster);
    }

    public OpponentType getNextMonsterToKill() {
        return monstersToKill.get(0);
    }

    public boolean hasMoreMonstersToKill() {
        return !monstersToKill.isEmpty();
    }

    public void setActualOpponent(OpponentType actualMonster) {
        this.actualMonster = actualMonster;
        setEnemy(new EnemyModel(actualMonster));
    }

    public List<OpponentType> getKilledMonsters() {
        return killedMonsters;
    }

    public void setEnemyHp(int enemyHp) {
        this.enemy.setHp(enemyHp);
    }

    public int getEnemyHp() {
        return enemy.getHp().getValue();
    }

    public int getPlayerHp() {
        return player.getHp().getValue();
    }

    public List<SkillModel> getSkillsModels() {
        return skillsModels;
    }

    public void setSkillsModels(List<SkillModel> skillsModels) {
        this.skillsModels = skillsModels;
    }

    public int getPlayerMp() {
        return player.getMp().getValue();
    }

    public void setPlayerMp(int playerMp) {
        player.getMp().setValue(playerMp);
    }

    public void setPlayerHp(int playerHp) {
        this.player.getHp().setValue(playerHp);
    }
}
