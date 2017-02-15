package pl.aml.adventure;

import pl.aml.impl.item.ItemType;

import java.util.Arrays;

public class GetItem implements AStage {

    private final ItemType[] items;

    public GetItem(ItemType... items) {
        this.items = items;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.playerGetItem(Arrays.asList(items));
    }
}
