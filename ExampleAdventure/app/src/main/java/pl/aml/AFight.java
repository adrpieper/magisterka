package pl.aml;

import java.util.Arrays;

public class AFight implements AStage {
    private MonsterType[] opponents;

    AFight(MonsterType[] opponents) {
        this.opponents = opponents;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.fight(Arrays.asList(opponents));
    }
}
