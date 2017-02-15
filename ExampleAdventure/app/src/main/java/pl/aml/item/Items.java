package pl.aml.item;

import pl.aml.character.StatType;

public class Items {

    public static Bonus plus(int amount, StatType statType) {
        return new Bonus(statType,amount);
    }
}
