package pl.aml;

public class End implements AStage {

    @Override
    public void run(AdventureEngine initializer) {
        initializer.end();
    }
}
