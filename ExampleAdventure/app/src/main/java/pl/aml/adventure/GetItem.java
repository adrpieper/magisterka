package pl.aml.adventure;

import pl.aml.items.ItemType;

public class GetItem implements AStage {

    private final ItemType itemType;

    public GetItem(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.playerGetItem(itemType);
    }
}
