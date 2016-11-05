package pl.edu.ug.inf.am.adventure.model;

import pl.aml.Location;

/**
 * Created by Adi on 2016-09-19.
 */
public class AdventureModel {

    private final Location location;
    private final EnemyModel enemy;

    public AdventureModel(Location location, EnemyModel enemy) {
        this.location = location;
        this.enemy = enemy;
    }

    public EnemyModel getEnemy() {
        return enemy;
    }

    public Location getLocation() {
        return location;
    }
}
