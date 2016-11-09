package pl.aml;

/**
 * Created by adrian on 07.11.16.
 */
public class AFight implements AStage {
    private MonsterType[] opponents;

    AFight(MonsterType[] opponents) {
        this.opponents = opponents;
    }

    public MonsterType[] getOpponents() {
        return opponents;
    }

    @Override
    public void show(AStageDisplayer manager) {
        manager.show(this);
    }

    @Override
    public void init(AStageInitializer initializer) {
        initializer.init(this);
    }
}
