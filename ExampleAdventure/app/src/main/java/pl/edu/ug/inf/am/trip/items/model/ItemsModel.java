package pl.edu.ug.inf.am.trip.items.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import com.android.databinding.library.baseAdapters.BR;
import pl.aml.character.Stats;
import pl.aml.impl.item.ItemType;
import pl.aml.item.SlotType;
import pl.edu.ug.inf.am.game.state.ItemsState;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ItemsModel extends BaseObservable{

    private final ObservableArrayList<ItemType> items;
    private final Map<SlotType, SlotModel> slots = new EnumMap<>(SlotType.class);
    private Stats stats;

    public ItemsModel(ItemsState itemsState) {
        this.items = new ObservableArrayList<>();
        this.items.addAll(itemsState.getItemsInBag());
        for (SlotType slotType : SlotType.values()) {
            SlotModel slotModel = new SlotModel(slotType);
            slotModel.setItemType(itemsState.getItem(slotType));
            slots.put(slotType, slotModel);
        }
    }

    public void setStats(Stats stats) {
        this.stats = stats;
        notifyPropertyChanged(BR.stats);
    }

    @Bindable
    public Stats getStats() {
        return stats;
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
