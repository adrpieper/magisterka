package pl.aml.adventure.definition;

import pl.aml.adventure.AStage;

import static pl.aml.location.Place.CASTLE;
import static pl.aml.opponent.OpponentType.TROLL;
import static pl.aml.adventure.AmlInternalDSL.*;

public class ExampleTroll implements AdventureDefinition{

    @Override
    public AStage define() {
        return aFightWith(TROLL)
                .onWin(add(CASTLE, ExampleDragon.class))
                .build();
    }
}
