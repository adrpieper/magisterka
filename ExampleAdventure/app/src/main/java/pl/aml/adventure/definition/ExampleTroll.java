package pl.aml.adventure.definition;

import pl.aml.adventure.AStage;

import static pl.aml.location.Place.CASTLE;
import static pl.aml.opponent.OpponentType.TROLL;
import static pl.aml.adventure.AmlInternalDSL.aFight;
import static pl.aml.adventure.AmlInternalDSL.add;

public class ExampleTroll implements AdventureDefinition{

    @Override
    public AStage define() {
        return aFight()
                .with(TROLL)
                .onWin(add(CASTLE, ExampleDragon.class))
                .build();
    }
}
