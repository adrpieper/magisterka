package pl.aml.character;

public interface FightEngine {

    void takeDamage(int damage);

    void getDamage(int damage);

    FightValues getValues();

}
