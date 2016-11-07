package pl.edu.ug.inf.am.adventure.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableInt;
import pl.aml.MonsterType;

/**
 * Created by Adi on 2016-09-16.
 */
public class EnemyModel extends BaseObservable {
    public final ObservableInt health = new ObservableInt();
    private final String name;

    public EnemyModel(MonsterType monster){
        this(monster.name(), monster.getHp());

    }

    public EnemyModel(String name, int health) {
        this.health.set(health);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}