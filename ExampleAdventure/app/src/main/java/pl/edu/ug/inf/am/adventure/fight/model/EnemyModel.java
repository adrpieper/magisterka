package pl.edu.ug.inf.am.adventure.fight.model;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.model.BarModel;

public class EnemyModel {
    private final BarModel hp;
    private final MonsterType monster;

    public EnemyModel(MonsterType monster){
        this.monster = monster;
        this.hp = new BarModel(monster.getHp());
    }

    public BarModel getHp() {
        return hp;
    }

    public MonsterType getMonster() {
        return monster;
    }

    public void setHp(int hp) {
        this.hp.setValue(hp);
    }
}