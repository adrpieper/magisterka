package pl.aml.character;

public abstract class Damage implements Effect{

    public Damage() {
    }

    @Override
    public void use(FightEngine engine) {
        engine.takeDamage(calculateDamage(engine.getValues()));
    }

    protected abstract int calculateDamage(FightValues fightValues);
}
