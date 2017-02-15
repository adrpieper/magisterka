package pl.aml.impl.start;

import pl.aml.adventure.AdventureInstance;

import java.util.List;

import pl.aml.impl.adventure.ExampleDragon;
import pl.aml.impl.adventure.ExampleTroll;

import static pl.aml.impl.location.Place.*;

public class AdventuresOnStart {

    public void load(List<AdventureInstance> instances) {

        instances.add(new AdventureInstance(CASTLE, ExampleTroll.class));
        instances.add(new AdventureInstance(FORREST, ExampleDragon.class, 1));
    }
}
