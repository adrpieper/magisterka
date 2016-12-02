package pl.aml.character;

public class Damage implements Effect{
    private final int amount;

    public Damage(int amount) {
        this.amount = amount;
    }

    @Override
    public void use(FightEngine engine) {
        engine.takeDamage(amount);
    }
}
