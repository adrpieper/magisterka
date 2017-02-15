package pl.edu.ug.inf.am.adventure.fight.model;

import pl.aml.impl.opponent.OpponentType;
import pl.edu.ug.inf.am.adventure.model.BarModel;

public class EnemyModel {
    private final BarModel hp;
    private final OpponentType monster;

    public EnemyModel(OpponentType monster){
        this.monster = monster;
        this.hp = new BarModel(monster.getHp());
    }

    public BarModel getHp() {
        return hp;
    }

    public OpponentType getMonster() {
        return monster;
    }

    public void setHp(int hp) {
        this.hp.setValue(hp);
    }
}