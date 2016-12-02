package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightConsoleModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightBasicSteps {

    private FightModel fight;
    private FightConsoleModel console;
    private DamageCalculator damageCalculator;
    private FightEngineImpl fightEngine;

    @Inject
    public FightBasicSteps(FightModel fight, FightConsoleModel console, DamageCalculator damageCalculator, FightEngineImpl fightEngine) {
        this.fight = fight;
        this.damageCalculator = damageCalculator;
        this.fightEngine = fightEngine;
    }

    public void enemyAttack() {

        int damage = damageCalculator.calcOpponentDamage(fight.getEnemy());
        fightEngine.getDamage(damage);
    }

    public void playerBasicAttack() {

        int damage = damageCalculator.calcPlayerDamage(fight.getPlayer());
        fightEngine.takeDamage(damage);

    }
}
