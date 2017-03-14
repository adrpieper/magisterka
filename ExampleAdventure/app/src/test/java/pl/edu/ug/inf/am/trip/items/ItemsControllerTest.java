package pl.edu.ug.inf.am.trip.items;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.impl.item.ItemType;
import pl.aml.item.SlotType;
import pl.edu.ug.inf.am.game.player.PlayerStatsUpdater;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;
import pl.edu.ug.inf.am.trip.items.model.ItemsModel;
import pl.edu.ug.inf.am.trip.model.StatsModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-03-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {
    @Mock
    private StatsModel statsModel;
    @Mock
    private ItemsState itemsState;
    @Mock
    private PlayerStatsState playerStatsState;
    @Mock
    private PlayerStatsUpdater statsUpdater;
    @Mock
    private ItemsModel itemsModel;
    @InjectMocks
    private ItemsController underTest;

    private ItemType ITEM = ItemType.SWORD;
    private SlotType ITEM_SLOT = ItemType.SWORD.getSlotType();

    @Test
    public void takeOffItem_whenSlotIsUsed() throws Exception {
        whenSlotIsUsed();

        underTest.takeOffItem(ITEM_SLOT, itemsModel);

        verifyCalculateStats();
        verifyItemTakeOff();
    }

    @Test
    public void takeOnItem_whenSlotIsEmpty() throws Exception {
        whenSlotIsEmpty();

        underTest.takeOnItem(ITEM,itemsModel);

        verifyTakeOnItem();
        verifyCalculateStats();
        verifyNoInteractionWithSlot();
    }

    @Test
    public void takeOnItem_whenSlotIsUsed() throws Exception {
        whenSlotIsUsed();

        underTest.takeOnItem(ITEM,itemsModel);

        verifyTakeOnItem();
        verifyCalculateStats();
        verifyItemTakeOff();
    }

    @Test
    public void takeOffItem_whenSlotIsEmpty() throws Exception {
        whenSlotIsEmpty();

        underTest.takeOffItem(ITEM_SLOT, itemsModel);

        verifyCalculateStats();
        verifyNoInteractionWithSlot();
    }

    private void verifyItemTakeOff() {
        verify(itemsState).emptySlot(ITEM_SLOT);
        verify(itemsModel).emptySlot(ITEM_SLOT);
        verify(itemsState).addItemToBag(ITEM);
        verify(itemsModel).addItemToBag(ITEM);
    }

    private void verifyCalculateStats() {
        verify(statsUpdater).updateBonusStats();
        verify(statsModel).setBonus(playerStatsState.getBonus());
    }

    private void verifyTakeOnItem() {
        verify(itemsState).removeItemFromBag(ITEM);
        verify(itemsModel).removeItemFromBag(ITEM);
        verify(itemsState).putItemOnSlot(ITEM);
        verify(itemsModel).putItemOnSlot(ITEM);
    }

    private void verifyNoInteractionWithSlot() {
        verify(itemsState).isSlotEmpty(ITEM_SLOT);
        verifyNoMoreInteractions(itemsModel);
        verifyNoMoreInteractions(itemsState);
    }

    private void whenSlotIsEmpty() {
        when(itemsState.isSlotEmpty(ITEM_SLOT)).thenReturn(true);
    }


    private void whenSlotIsUsed() {
        when(itemsState.isSlotEmpty(ITEM_SLOT)).thenReturn(false);
        when(itemsState.getItem(ITEM_SLOT)).thenReturn(ITEM);
    }
}