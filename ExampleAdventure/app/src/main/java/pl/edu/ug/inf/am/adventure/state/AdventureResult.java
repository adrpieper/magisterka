package pl.edu.ug.inf.am.adventure.state;

import pl.aml.impl.items.ItemType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PerAdventure
public class AdventureResult {

    @Inject
    public AdventureResult() {}

    private boolean accepted;
    private int gainedExp;
    private List<ItemType> collectedItems = new ArrayList<>();
    private int levelAchieved = -1;

    public void setLevelAchieved(int levelAchieved) {
        this.levelAchieved = levelAchieved;
    }

    public int getLevelAchieved() {
        return levelAchieved;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void addExperience(int gainedExp) {
        this.gainedExp += gainedExp;
    }

    public int getGainedExp() {
        return gainedExp;
    }

    public void addItems(List<ItemType> gainedItems) {
        collectedItems.addAll(gainedItems);
    }

    public List<ItemType> getCollectedItems() {
        return collectedItems;
    }
}
