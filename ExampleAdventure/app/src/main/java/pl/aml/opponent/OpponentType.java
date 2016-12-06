package pl.aml.opponent;


import pl.aml.items.ItemType;

import static pl.aml.items.ItemType.*;

public enum OpponentType {
    TROLL(20,10,100, loot(SWORD,10), loot(HELMET,50) ),
    DRAGON(25,10,100, loot(SWORD,100))
    ;
    private final int hp;
    private final int power;
    private final int exp;
    private final ItemLoot[] loots;

    OpponentType(int hp, int power, int exp, ItemLoot... loots)  {
        this.hp = hp;
        this.power = power;
        this.exp = exp;
        this.loots = loots;
    }
    
    public int getHp() {
        return hp;
    }
    public int getPower() {
        return power;
    }
    public int getExp() {
        return exp;
    }
    public ItemLoot[] getLoots() {
        return loots;
    }

    private static ItemLoot loot(ItemType itemType, int change) {
        return new ItemLoot(itemType, change);
    }
}
