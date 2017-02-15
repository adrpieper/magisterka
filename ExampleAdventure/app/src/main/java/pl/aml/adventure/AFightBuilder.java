package pl.aml.adventure;

import pl.aml.impl.opponent.OpponentType;

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

    public AFightBuilder onWin(AStageBuilder doOnWin) {
        return onWin(doOnWin.build());
    }

    public AFightBuilder onLost(AStage doOnLost) {
        this.doOnLost = doOnLost;
        return this;
    }

    public AFightBuilder onLost(AStageBuilder doOnLost) {
        return onLost(doOnLost.build());
    }

    @Override
    public AFight build() {
        return new AFight(opponents, doOnWin, doOnLost);
    }
}