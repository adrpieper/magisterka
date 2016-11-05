package pl.edu.ug.inf.am.adventure.model;

import pl.edu.ug.inf.am.player.model.PlayerModel;

/**
 * Created by Adi on 2016-09-19.
 */
public class FightModel {

    private final EnemyModel enemyModel;
    private final PlayerModel playerModel;

    public FightModel(EnemyModel enemyModel, PlayerModel playerModel) {
        this.enemyModel = enemyModel;
        this.playerModel = playerModel;
    }

    public EnemyModel getEnemyModel() {
        return enemyModel;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }
}
