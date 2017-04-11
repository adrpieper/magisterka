package pl.aml.character;

public class Stats {
    private static final Stats defaultValue = new Stats(0, 0, 0);
    private final int intelligence;
    private final int strength;
    private final int agility;

    public Stats(int strength, int intelligence, int agility) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int get(StatType statType) {
        if (statType == StatType.INTELLIGENCE)
            return intelligence;
        if (statType == StatType.STRENGTH)
            return strength;
        if (statType == StatType.AGILITY)
            return agility;
        throw new RuntimeException();
    }

    public static Stats defaultValue() {
        return defaultValue;
    }

    public Stats plus(Stats stats) {
        return new Stats(
                strength + stats.strength, intelligence + stats.intelligence,
                agility + stats.agility
        );
    }
}
