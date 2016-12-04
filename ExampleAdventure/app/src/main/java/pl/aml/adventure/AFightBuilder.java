package pl.aml.adventure;

import pl.aml.MonsterType;

public class AFightBuilder implements AStageBuilder{
    private MonsterType[] opponents;
    private AStage doOnWin = End.instance();
    private AStage doOnLost = End.instance();

    public AFightBuilder with(MonsterType... opponents) {
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