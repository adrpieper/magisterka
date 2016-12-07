package pl.edu.ug.inf.am.trip.items;

import pl.aml.items.ItemType;
import pl.aml.items.SlotType;
import pl.edu.ug.inf.am.game.player.PlayerStatsUpdater;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.items.model.ItemsModel;
import pl.edu.ug.inf.am.trip.model.StatsModel;

import javax.inject.Inject;

@PerTrip
public class ItemsController {

    private final StatsModel statsModel;
    private final ItemsState itemsState;
    private final PlayerStatsState playerStatsState;
    private final PlayerStatsUpdater statsUpdater;

    @Inject
    public ItemsController(StatsModel statsModel, ItemsState itemsState, PlayerStatsState playerStatsState, PlayerStatsUpdater statsUpdater) {
        this.statsModel = statsModel;
        this.itemsState = itemsState;
        this.playerStatsState = playerStatsState;
        this.statsUpdater = statsUpdater;
    }

    public ItemsModel createModel() {
        ItemsModel itemsModel = new ItemsModel(itemsState);
        calculateStats();
        return itemsModel;
    }

    public void takeOnItem(ItemType itemType, ItemsModel itemsModel){

        removeItem(itemType.getSlotType(), itemsModel);
        itemsState.removeItemFromBag(itemType);
        itemsModel.removeItemFromBag(itemType);
        itemsState.putItemOnSlot(itemType);
        itemsModel.putItemOnSlot(itemType);
        calculateStats();
    }

    public void takeOffItem(SlotType slotType, ItemsModel itemsModel){
        removeItem(slotType, itemsModel);
        calculateStats();
    }

    private void calculateStats() {
        statsUpdater.updateBonusStats();
        statsModel.setBonus(playerStatsState.getBonus());
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
