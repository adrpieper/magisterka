package pl.edu.ug.inf.am.adventure.state;

import pl.aml.ItemType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;

import javax.inject.Inject;
import java.util.List;

@PerAdventure
public class AdventureResult {

    @Inject
    public AdventureResult() {}

    private int gainedExp;
    private List<ItemType> collectedItems;

    public void addExperience(int gainedExp) {
        this.gainedExp += gainedExp;
    }

    public int getGainedExp() {
        return gainedExp;
    }
}
