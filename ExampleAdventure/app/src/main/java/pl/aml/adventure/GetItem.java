package pl.aml.adventure;

import pl.aml.impl.items.ItemType;

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
