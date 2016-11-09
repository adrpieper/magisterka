package pl.edu.ug.inf.am.adventure.model;

import android.databinding.ObservableInt;
import pl.aml.MonsterType;

public class EnemyModel {
    public final ObservableInt health = new ObservableInt();
    private final String name;

    public EnemyModel(MonsterType monster){
        this(monster, monster.getHp());
    }

    public EnemyModel(MonsterType actualMonster, int enemyHealth) {
        this(actualMonster.name(), enemyHealth);
    }

    public EnemyModel(String name, int health) {
        this.health.set(health);
        this.name = name;
    }


    public String getName() {
        return name;
    }
}