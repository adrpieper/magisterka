package pl.aml.adventure;

import pl.aml.opponent.OpponentType;

public class AFightBuilder implements AStageBuilder{
    private OpponentType[] opponents;
    private AStage doOnWin = End.instance();
    private AStage doOnLost = End.instance();

    public AFightBuilder with(OpponentType... opponents) {
        this.opponents = opponents;
        return this;
    }

    public AFightBuilder onWin(AStage doOnWin) {
        this.doOnWin = doOnWin;
        return this;
    }

    public AFightBuilder onLost(AStage doOnLost) {
        this.doOnLost = doOnLost;
        return this;
    }

    @Override
    public AFight build() {
        return new AFight(opponents, doOnWin, doOnLost);
    }
}