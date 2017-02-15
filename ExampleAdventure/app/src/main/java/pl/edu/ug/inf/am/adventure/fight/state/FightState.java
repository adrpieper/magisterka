package pl.edu.ug.inf.am.adventure.fight.state;

import pl.aml.impl.opponent.OpponentType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PerAdventureStage
public class FightState {
    private int enemyHealth;
    private Result result;
    private List<OpponentType> monstersToKill = new ArrayList<>();
    private List<OpponentType> killedMonsters = new ArrayList<>();
    private OpponentType actualMonster;

    public FightState(Collection<OpponentType> monsters) {
        this.monstersToKill.addAll(monsters);
        OpponentType actualMonster = monstersToKill.get(0);
        setActualMonster(actualMonster);
        setEnemyHealth(actualMonster.getHp());
        result = Result.FIGHT;
    }

    public List<OpponentType> getKilledMonsters() {
        return killedMonsters;
    }

    public List<OpponentType> getMonstersToKill() {
        return monstersToKill;
    }

    public void addKilledMonster(OpponentType monster) {
        killedMonsters.add(monster);
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setActualMonster(OpponentType actualMonster) {
        this.actualMonster = actualMonster;
    }

    public OpponentType getActualMonster() {
        return actualMonster;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void removeMonsterToKill(OpponentType opponentType) {
        monstersToKill.remove(opponentType);
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void nextMonster() {
        OpponentType nextMonster = monstersToKill.get(0);
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
