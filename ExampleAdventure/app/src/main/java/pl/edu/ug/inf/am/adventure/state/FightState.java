package pl.edu.ug.inf.am.adventure.state;

import pl.aml.MonsterType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FightState extends AStageState {
    private int enemyHealth = 100;
    private boolean isEnd = false;
    private List<MonsterType> monstersToKill = new ArrayList<>();
    private List<MonsterType> killedMonsters = new ArrayList<>();
    private MonsterType actualMonster;

    public FightState(MonsterType... monsters) {
        this.monstersToKill.addAll(Arrays.asList(monsters));
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

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void setActualMonster(MonsterType actualMonster) {
        this.actualMonster = actualMonster;
    }

    public MonsterType getActualMonster() {
        return actualMonster;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }
}
