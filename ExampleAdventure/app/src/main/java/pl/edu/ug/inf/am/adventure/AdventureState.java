package pl.edu.ug.inf.am.adventure;

import pl.aml.Location;
import pl.aml.Monster;
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
    private List<Monster> monstersToKill = new ArrayList<>();
    private List<Monster> killedMonsters = new ArrayList<>();
    private Monster actualMonster;

    public AdventureState(Location location, Monster... monsters) {
        this.location = location;
        this.monstersToKill.addAll(Arrays.asList(monsters));
    }

    public List<Monster> getKilledMonsters() {
        return killedMonsters;
    }

    public List<Monster> getMonstersToKill() {
        return monstersToKill;
    }

    public void addKilledMonster(Monster monster) {}

    public Location getLocation() {
        return location;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void setActualMonster(Monster actualMonster) {
        this.actualMonster = actualMonster;
    }

    public Monster getActualMonster() {
        return actualMonster;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
