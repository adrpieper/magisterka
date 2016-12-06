package pl.aml.items;

import pl.aml.character.StatType;

public class Bonus {
    private final StatType statType;
    private final int amount;

    public Bonus(StatType statType, int amount) {
        this.statType = statType;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public StatType getStatType() {
        return statType;
    }
}
