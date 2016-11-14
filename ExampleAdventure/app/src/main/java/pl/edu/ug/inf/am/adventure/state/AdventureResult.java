package pl.edu.ug.inf.am.adventure.state;

import pl.aml.ItemType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;

import java.util.List;

@PerAdventure
public class AdventureResult {

    private int gainedExp;
    private List<ItemType> collectedItems;
}
