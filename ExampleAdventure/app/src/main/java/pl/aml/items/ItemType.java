package pl.aml.items;

public enum  ItemType {
    SWORD(100, SlotType.WEAPON),
    HELMET(100, SlotType.HELMET),

    ;
    private final int cost;
    private final SlotType slotType;

    private ItemType(int cost, SlotType slotType) {
        this.cost = cost;
        this.slotType = slotType;
    }

    public int getCost() {
        return cost;
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
