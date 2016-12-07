package pl.edu.ug.inf.am.trip.items;

import pl.aml.items.ItemType;
import pl.aml.items.SlotType;
import pl.edu.ug.inf.am.game.player.PlayerStatsUpdater;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.items.model.ItemsModel;

import javax.inject.Inject;

@PerTrip
public class ItemsController {

    private final ItemsState itemsState;
    private final PlayerStatsState playerStatsState;
    private final PlayerStatsUpdater statsUpdater;

    @Inject
    public ItemsController(ItemsState itemsState, PlayerStatsState playerStatsState, PlayerStatsUpdater statsUpdater) {
        this.itemsState = itemsState;
        this.playerStatsState = playerStatsState;
        this.statsUpdater = statsUpdater;
    }

    public ItemsModel createModel() {
        ItemsModel itemsModel = new ItemsModel(itemsState);
        calculateStats(itemsModel);
        return itemsModel;
    }

    public void takeOnItem(ItemType itemType, ItemsModel itemsModel){

        removeItem(itemType.getSlotType(), itemsModel);
        itemsState.removeItemFromBag(itemType);
        itemsModel.removeItemFromBag(itemType);
        itemsState.putItemOnSlot(itemType);
        itemsModel.putItemOnSlot(itemType);
        calculateStats(itemsModel);
    }

    public void takeOffItem(SlotType slotType, ItemsModel itemsModel){
        removeItem(slotType, itemsModel);
        calculateStats(itemsModel);
    }

    private void calculateStats(ItemsModel itemsModel) {
        statsUpdater.updateBonusStats();
        itemsModel.setStats(playerStatsState.getBonus());
    }

    private void removeItem(SlotType slotType, ItemsModel itemsModel) {
        if (!itemsState.isSlotEmpty(slotType)) {
            ItemType item = itemsState.getItem(slotType);
            itemsState.emptySlot(slotType);
            itemsModel.emptySlot(slotType);
            itemsState.addItemToBag(item);
            itemsModel.addItemToBag(item);
        }
    }
}
