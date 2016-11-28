package pl.aml.adventure;

public class ConditionBuilder implements AStageBuilder{

    private APredicate predicate;
    private AStage doOnTrue;
    private AStage doOnFalse;

    public ConditionBuilder withPredicate(APredicate predicate) {
        this.predicate = predicate;
        return this;
    }

    public void ifFalse(AStage doOnFalse) {
        this.doOnFalse = doOnFalse;
    }

    public void ifTrue(AStage doOnTrue) {
        this.doOnTrue = doOnTrue;
    }

    @Override
    public ConditionStage build() {
        return new ConditionStage(predicate, doOnTrue, doOnFalse);
    }
}
