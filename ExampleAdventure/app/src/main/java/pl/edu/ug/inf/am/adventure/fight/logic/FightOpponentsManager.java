package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.impl.opponent.OpponentType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;

import javax.inject.Inject;
import java.util.List;

@PerAdventureStage
public class FightOpponentsManager {

    private FightModel fight;

    @Inject
    public FightOpponentsManager(FightModel fight) {
        this.fight = fight;
    }

    public void setOpponentsToKill(List<OpponentType> opponentsToKill) {
        fight.settOpponentsToKill(opponentsToKill);
        fight.setActualOpponent(opponentsToKill.get(0));
        fight.setFightStatus(FightStatus.PLAYER_TURN);
    }

    public void nextMonster() {
        OpponentType nextMonster = fight.getNextMonsterToKill();
        fight.setActualOpponent(nextMonster);
        fight.setFightStatus(FightStatus.PLAYER_TURN);
    }
}
