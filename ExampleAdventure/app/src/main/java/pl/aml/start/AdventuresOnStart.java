package pl.aml.start;

import pl.aml.adventure.AdventureInstance;

import java.util.List;

import pl.aml.adventure.definition.*;
import static pl.aml.location.Place.*;

public class AdventuresOnStart {

    public void load(List<AdventureInstance> instances) {

        instances.add(new AdventureInstance(CASTLE, ExampleTroll.class));
        instances.add(new AdventureInstance(FORREST, ExampleDragon.class, 1));
    }
}
