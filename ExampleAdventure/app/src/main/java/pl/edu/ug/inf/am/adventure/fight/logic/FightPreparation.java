package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.opponent.OpponentType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

import javax.inject.Inject;
import java.util.List;

@PerAdventureStage
public class FightPreparation {
    private final SkillsLogic skillsLogic;
    private final FightOpponentsManager opponentsManager;

    @Inject
    public FightPreparation(SkillsLogic skillsLogic, FightOpponentsManager opponentsManager) {
        this.skillsLogic = skillsLogic;
        this.opponentsManager = opponentsManager;
    }

    public void prepare(List<OpponentType> opponents) {
        opponentsManager.setOpponentsToKill(opponents);
        skillsLogic.createSkillsList();
    }
}
