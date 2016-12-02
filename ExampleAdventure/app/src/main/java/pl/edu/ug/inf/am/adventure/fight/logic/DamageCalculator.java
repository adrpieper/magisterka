package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

import javax.inject.Inject;

@PerAdventureStage
public class DamageCalculator {

    @Inject
    public DamageCalculator() {
    }

    public int calcOpponentDamage(EnemyModel enemy) {
        int opponentPower = enemy.getMonster().getPower();
        return opponentPower * 1;
    }

    public int calcPlayerDamage(AdventurePlayerModel player) {
        return player.getLevel() * 10;
    }
}
