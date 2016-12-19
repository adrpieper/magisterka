package pl.adrian.pieper.generator.adventure;

import pl.adrian.pieper.aML.Adventure;

public class AdventureClassNameGenerator {
    public String generateClassName(Adventure adventure){
        return adventure.getName() + "AdventureDefinition";
    }
}
