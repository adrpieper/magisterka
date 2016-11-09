package pl.aml;

public class End implements AStage {
    @Override
    public void show(AStageDisplayer manager) {
        manager.show(this);
    }

    @Override
    public void init(AStageInitializer initializer) {
        initializer.init(this);
    }
}
