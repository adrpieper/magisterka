package pl.aml.adventure;

public enum End implements AStage, AStageBuilder {
    INSTANCE;

    public static End instance() {
        return INSTANCE;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.end();
    }

    @Override
    public AStage build() {
        return this;
    }
}
