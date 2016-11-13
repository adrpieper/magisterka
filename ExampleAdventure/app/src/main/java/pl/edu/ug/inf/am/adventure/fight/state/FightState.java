package pl.edu.ug.inf.am.adventure.fight.state;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PerAdventureStage
public class FightState {
    private int enemyHealth;
    private Result result;
    private List<MonsterType> monstersToKill = new ArrayList<>();
    private List<MonsterType> killedMonsters = new ArrayList<>();
    private MonsterType actualMonster;

    public FightState(Collection<MonsterType> monsters) {
        this.monstersToKill.addAll(monsters);
        MonsterType actualMonster = monstersToKill.get(0);
        setActualMonster(actualMonster);
        setEnemyHealth(actualMonster.getHp());
        result = Result.FIGHT;
    }

    public List<MonsterType> getKilledMonsters() {
        return killedMonsters;
    }

    public List<MonsterType> getMonstersToKill() {
        return monstersToKill;
    }

    public void addKilledMonster(MonsterType monster) {}

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }


    public void setActualMonster(MonsterType actualMonster) {
        this.actualMonster = actualMonster;
    }

    public MonsterType getActualMonster() {
        return actualMonster;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void removeMonsterToKill(MonsterType monsterType) {
        monstersToKill.remove(monsterType);
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void nextMonster() {
        MonsterType nextMonster = monstersToKill.get(0);
        setActualMonster(nextMonster);
        setEnemyHealth(nextMonster.getHp());
        setResult(FightState.Result.FIGHT);
    }

    public enum Result {
        WIN(true),
        LOST(true),
        ENEMY_KILLED(false),
        FIGHT(false);

        private final boolean isEnd;

        Result(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
