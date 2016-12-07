package pl.aml.character;

public enum SkillType {
    BASIC_HIT(new Damage() {
        @Override
        protected int calculateDamage(FightValues fightValues) {
            return fightValues.playerStr() * 15;
        }
    }, 2, 2),
    POISON_HIT(new Damage() {
        @Override
        protected int calculateDamage(FightValues fightValues) {
            return fightValues.playerStr() * 25;
        }
    }, 4, 3),
    SUPER_POISON_HIT(new Damage() {
        @Override
        protected int calculateDamage(FightValues fightValues) {
            return fightValues.playerStr() * 50;
        }
    }, 10, 5);

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
