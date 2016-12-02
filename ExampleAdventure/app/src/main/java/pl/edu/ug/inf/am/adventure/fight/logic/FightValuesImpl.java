package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.character.FightValues;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightValuesImpl implements FightValues{

    private final AdventurePlayerModel playerModel;

    @Inject
    public FightValuesImpl(AdventurePlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    @Override
    public int playerLevel() {
        return playerModel.getLevel();
    }
}
