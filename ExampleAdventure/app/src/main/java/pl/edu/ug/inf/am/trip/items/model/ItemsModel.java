package pl.edu.ug.inf.am.trip.items.model;

import android.databinding.ObservableArrayList;
import pl.aml.items.ItemType;
import pl.aml.items.SlotType;
import pl.edu.ug.inf.am.game.state.ItemsState;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ItemsModel {

    private final ObservableArrayList<ItemType> items;
    private final Map<SlotType, SlotModel> slots = new EnumMap<>(SlotType.class);

    public ItemsModel(ItemsState itemsState) {
        this.items = new ObservableArrayList<>();
        this.items.addAll(itemsState.getItemsInBag());
        for (SlotType slotType : SlotType.values()) {
            SlotModel slotModel = new SlotModel(slotType);
            slotModel.setItemType(itemsState.getItem(slotType));
            slots.put(slotType, slotModel);
        }
    }

    public Collection<SlotModel> getSlots() {
        return slots.values();
    }

    public List<ItemType> getItemsInBag() {
        return items;
    }

    public void addItemToBag(ItemType itemType) {
        items.add(itemType);
    }

    public void removeItemFromBag(ItemType itemType) {
        items.remove(itemType);
    }

    public void putItemOnSlot(ItemType itemType) {
        slots.get(itemType.getSlotType()).setItemType(itemType);
    }

    public void emptySlot(SlotType slotType) {
        slots.get(slotType).setItemType(null);
    }
}
