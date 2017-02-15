package pl.edu.ug.inf.am.adventure.fight.state;

import pl.aml.impl.items.ItemType;

import java.util.List;

public class ResultDTO {
    private final Result result;
    private final int gainedExp;
    private final List<ItemType> gainedItems;

    public ResultDTO(Result result, int gainedExp, List<ItemType> gainedItems) {
        this.result = result;
        this.gainedExp = gainedExp;
        this.gainedItems = gainedItems;
    }

    public int getGainedExp() {
        return gainedExp;
    }

    public List<ItemType> getGainedItems() {
        return gainedItems;
    }

    public Result getResult() {
        return result;
    }
}
