package pl.aml;

public interface AStage {
    void show(AStageDisplayer manager);
    void init(AStageInitializer initializer);
}
