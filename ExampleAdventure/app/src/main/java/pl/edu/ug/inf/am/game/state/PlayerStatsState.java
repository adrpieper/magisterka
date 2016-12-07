package pl.edu.ug.inf.am.game.state;

import pl.aml.character.Stats;

public class PlayerStatsState {
    private Stats basic = Stats.defaultValue();
    private Stats bonus = Stats.defaultValue();

    public void setBasic(Stats basic) {
        this.basic = basic;
    }

    public void setBonus(Stats bonus) {
        this.bonus = bonus;
    }

    public Stats getBasic() {
        return basic;
    }

    public Stats getBonus() {
        return bonus;
    }

    public Stats getFull() {
        return basic.plus(bonus);
    }
}
