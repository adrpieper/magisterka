package pl.aml.adventure;

import pl.aml.impl.opponent.OpponentType;

import java.util.Arrays;

public class AFight implements AStage {
    private final OpponentType[] opponents;
    private final AStage doOnWin;
    private final AStage doOnLost;

    AFight(OpponentType[] opponents) {
        this(opponents, End.instance(), End.instance());
    }

    AFight(OpponentType[] opponents, AStage doOnWin) {
        this(opponents, doOnWin, End.instance());
    }

    AFight(OpponentType[] opponents, AStage doOnWin, AStage doOnLost) {
        this.opponents = opponents;
        this.doOnWin = doOnWin;
        this.doOnLost = doOnLost;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.fight(Arrays.asList(opponents), doOnWin, doOnLost);
    }
}
