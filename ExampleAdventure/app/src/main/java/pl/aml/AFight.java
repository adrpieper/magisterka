package pl.aml;

import java.util.Arrays;

public class AFight implements AStage {
    private final MonsterType[] opponents;
    private final AStage doOnWin;
    private final AStage doOnLost;

    AFight(MonsterType[] opponents) {
        this(opponents, End.instance(), End.instance());
    }

    AFight(MonsterType[] opponents, AStage doOnWin) {
        this(opponents, doOnWin, End.instance());
    }

    AFight(MonsterType[] opponents, AStage doOnWin, AStage doOnLost) {
        this.opponents = opponents;
        this.doOnWin = doOnWin;
        this.doOnLost = doOnLost;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.fight(Arrays.asList(opponents), doOnWin, doOnLost);
    }
}
