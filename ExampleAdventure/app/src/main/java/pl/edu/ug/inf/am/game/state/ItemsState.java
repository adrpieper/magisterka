package pl.edu.ug.inf.am.game.state;

import pl.aml.items.ItemType;
import pl.aml.items.SlotType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ItemsState {

    private EnumMap<SlotType,ItemType> itemsOnSlot = new EnumMap<>(SlotType.class);
    private List<ItemType> itemsInBag = new ArrayList<>();

    {
        putItemOnSlot(ItemType.SWORD);
        addItemToBag(ItemType.HELMET);
    }

    public ItemType getItem(SlotType slotType) {
        return itemsOnSlot.get(slotType);
    }

    public void putItemOnSlot(ItemType itemType) {
        itemsOnSlot.put(itemType.getSlotType(),itemType);
    }

    public void addItemToBag(ItemType itemType) {
        itemsInBag.add(itemType);
    }

    public EnumMap<SlotType, ItemType> getItemsOnSlot() {
        return itemsOnSlot;
    }

    public List<ItemType> getItemsInBag() {
        return itemsInBag;
    }

    public void removeItemFromBag(ItemType itemType) {
        itemsInBag.remove(itemType);
    }

    public boolean isSlotEmpty(SlotType slotType) {
        return itemsOnSlot.get(slotType) == null;
    }

    public void emptySlot(SlotType slotType) {
        itemsOnSlot.remove(slotType);
    }

    public void addItemsToBag(List<ItemType> collectedItems) {
        itemsInBag.addAll(collectedItems);
    }
}
