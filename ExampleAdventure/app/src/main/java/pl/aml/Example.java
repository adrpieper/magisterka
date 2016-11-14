package pl.aml;

import static pl.aml.AmlInternalDSL.*;
import static pl.aml.Location.*;
import static pl.aml.MonsterType.*;

public class Example {

    public Adventure example() {

        return aNewAdventure()
            .in(CASTLE)
            .startsFrom(
                aQuestion("Do you want to removeSubcomponent?")
                    .withAnswer("Yes", aFightWith(TROLL,DRAGON))
                    .withAnswer("No", end())
            ).build();
    }

}
