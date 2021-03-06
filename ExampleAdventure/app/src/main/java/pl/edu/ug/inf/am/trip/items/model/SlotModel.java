package pl.edu.ug.inf.am.trip.items.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.impl.item.ItemType;
import pl.aml.item.SlotType;
import pl.edu.ug.inf.am.BR;

public class SlotModel extends BaseObservable{
    private final SlotType slotType;
    private ItemType itemType;

    public SlotModel(SlotType slotType) {
        this.slotType = slotType;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    @Bindable
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
        notifyPropertyChanged(BR.itemType);
    }

}
