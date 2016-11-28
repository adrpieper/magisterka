package pl.aml.adventure;

import static pl.aml.Location.*;
import static pl.aml.MonsterType.*;

public class Example {

    public Adventure example() {

        return AmlInternalDSL.aNewAdventure()
            .in(CASTLE)
            .startsFrom(
                AmlInternalDSL.aQuestion("Do you want to removeSubcomponent?")
                    .withAnswer("Yes", AmlInternalDSL.aFightWith(TROLL,DRAGON))
                    .withAnswer("No", AmlInternalDSL.end())
            ).build();
    }

}
