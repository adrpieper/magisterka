package pl.aml.opponent;

import pl.aml.impl.item.ItemType;

public class Opponents {

    public static ItemLoot loot(ItemType itemType, int change) {
        return new ItemLoot(itemType, change);
    }
}
