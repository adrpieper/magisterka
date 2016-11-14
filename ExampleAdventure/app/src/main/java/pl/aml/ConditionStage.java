package pl.aml;

public class ConditionStage implements AStage {
    private final APredicate predicate;
    private final AStage doOnTrue;
    private final AStage doOnFalse;

    public ConditionStage(APredicate predicate, AStage doOnTrue, AStage doOnFalse) {
        this.predicate = predicate;
        this.doOnTrue = doOnTrue;
        this.doOnFalse = doOnFalse;
    }

    @Override
    public void run(AdventureEngine engine) {
        if (engine.check(predicate)) {
            doOnTrue.run(engine);
        }else {
            doOnFalse.run(engine);
        }
    }
}
