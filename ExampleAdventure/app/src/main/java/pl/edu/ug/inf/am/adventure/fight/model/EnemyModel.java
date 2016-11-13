package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.ObservableInt;
import pl.aml.MonsterType;

public class EnemyModel {
    public final ObservableInt hp = new ObservableInt();
    public final String name;
    public final int maxHp;

    public EnemyModel(MonsterType monster){
        this(monster, monster.getHp());
    }

    public EnemyModel(MonsterType actualMonster, int hp) {
        this(actualMonster.name(), actualMonster.getHp(), hp);
    }

    public EnemyModel(String name, int maxHp, int hp) {
        this.maxHp = maxHp;
        this.hp.set(hp);
        this.name = name;
    }
}