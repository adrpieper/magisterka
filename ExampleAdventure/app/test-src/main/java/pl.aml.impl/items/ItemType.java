package pl.aml.impl.items;

import pl.aml.character.StatType;
import pl.aml.items.Bonus;
import pl.aml.items.SlotType;

import static pl.aml.character.StatType.*;

public enum  ItemType {
    SWORD(100, SlotType.WEAPON, plus(5, STRENGTH)),
    HELMET(100, SlotType.HELMET, plus(4, AGILITY)),

    ;
    private final int cost;
    private final SlotType slotType;
    private final Bonus[] bonuses;

    private ItemType(int cost, SlotType slotType,Bonus... bonuses) {
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

    private static Bonus plus(int amount, StatType statType) {
        return new Bonus(statType,amount);
    }

}
