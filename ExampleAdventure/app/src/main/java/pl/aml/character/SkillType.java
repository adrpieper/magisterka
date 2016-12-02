package pl.aml.character;

public enum SkillType {
    BASIC_HIT(new Damage(10), 2, 2),
    POISON_HIT(new Damage(20), 4, 3),
    SUPER_POISON_HIT(new Damage(30), 10, 5);

    private final Effect effect;
    private int mpCost;
    private int cooldown;

    SkillType(Effect effect, int mpCost, int cooldown) {
        this.effect = effect;
        this.mpCost = mpCost;
        this.cooldown = cooldown;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getMpCost() {
        return mpCost;
    }
}
