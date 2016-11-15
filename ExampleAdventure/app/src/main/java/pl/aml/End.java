package pl.aml;

public enum  End implements AStage {
    INSTANCE;

    public static End instance() {
        return INSTANCE;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.end();
    }

}
