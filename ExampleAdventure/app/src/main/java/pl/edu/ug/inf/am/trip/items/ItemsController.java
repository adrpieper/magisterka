package pl.edu.ug.inf.am.trip.items;

import pl.aml.items.ItemType;
import pl.aml.items.SlotType;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.items.model.ItemsModel;

import javax.inject.Inject;

@PerTrip
public class ItemsController {

    private final ItemsState itemsState;

    @Inject
    public ItemsController(ItemsState itemsState) {
        this.itemsState = itemsState;
    }

    public ItemsModel createModel() {
        return new ItemsModel(itemsState);
    }

    public void takeOnItem(ItemType itemType, ItemsModel itemsModel){

        takeOffItem(itemType.getSlotType(), itemsModel);
        itemsState.removeItemFromBag(itemType);
        itemsModel.removeItemFromBag(itemType);
        itemsState.putItemOnSlot(itemType);
        itemsModel.putItemOnSlot(itemType);
    }

    public void takeOffItem(SlotType slotType, ItemsModel itemsModel){
        if (!itemsState.isSlotEmpty(slotType)) {
            ItemType item = itemsState.getItem(slotType);
            itemsState.emptySlot(slotType);
            itemsModel.emptySlot(slotType);
            itemsState.addItemToBag(item);
            itemsModel.addItemToBag(item);
        }
    }
}
