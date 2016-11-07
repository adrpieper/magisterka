package pl.edu.ug.inf.am.adventure;

import pl.aml.Location;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.stage.StageState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adi on 2016-11-02.
 */
public class AdventureState extends StageState {
    private final Location location;
    private int enemyHealth = 100;
    private boolean isEnd = false;
    private List<MonsterType> monstersToKill = new ArrayList<>();
    private List<MonsterType> killedMonsters = new ArrayList<>();
    private MonsterType actualMonster;

    public AdventureState(Location location, MonsterType... monsters) {
        this.location = location;
        this.monstersToKill.addAll(Arrays.asList(monsters));
    }

    public List<MonsterType> getKilledMonsters() {
        return killedMonsters;
    }

    public List<MonsterType> getMonstersToKill() {
        return monstersToKill;
    }

    public void addKilledMonster(MonsterType monster) {}

    public Location getLocation() {
        return location;
    }

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
}
