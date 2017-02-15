package pl.aml.impl.item;

import pl.aml.item.*;

import static pl.aml.character.StatType.*;
import static pl.aml.item.Items.*;
import static pl.aml.item.SlotType.*;

public enum  ItemType {
    SWORD(100, WEAPON, plus(5, STRENGTH)),
    IRON_HELMET(100, HELMET, plus(4, AGILITY)),
    ;

    private final int cost;
    private final SlotType slotType;
    private final Bonus[] bonuses;

    ItemType(int cost, SlotType slotType, Bonus... bonuses) {
        this.cost = cost;
        this.slotType = slotType;
        this.bonuses = bonuses;
    }

    public int getCost() {
        return cost;
    }

    public Bonus[] getBonuses() {
        return bonuses;
    }

    public SlotType getSlotType() {
        return slotType;
    }

}
