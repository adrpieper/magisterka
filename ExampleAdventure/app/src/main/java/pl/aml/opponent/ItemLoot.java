package pl.aml.opponent;

import pl.aml.impl.items.ItemType;

public class ItemLoot {
    private final ItemType itemType;
    private final int chance;

    public ItemLoot(ItemType itemType, int chance) {
        this.itemType = itemType;
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public ItemType getItemType() {
        return itemType;
    }

}
