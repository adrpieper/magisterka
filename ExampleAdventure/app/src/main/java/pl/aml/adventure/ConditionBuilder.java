package pl.aml.adventure;

public class ConditionBuilder implements AStageBuilder{

    private APredicate predicate;
    private AStage doOnTrue;
    private AStage doOnFalse;

    public ConditionBuilder withPredicate(APredicate predicate) {
        this.predicate = predicate;
        return this;
    }

    public ConditionBuilder ifFalse(AStage doOnFalse) {
        this.doOnFalse = doOnFalse;
        return this;
    }

    public ConditionBuilder ifFalse(AStageBuilder doOnFalse) {
        return ifFalse(doOnFalse.build());
    }

    public ConditionBuilder ifTrue(AStage doOnTrue) {
        this.doOnTrue = doOnTrue;
        return this;
    }

    public ConditionBuilder ifTrue(AStageBuilder doOnTrue) {
        return ifTrue(doOnTrue.build());
    }

    @Override
    public ConditionStage build() {
        if (doOnFalse == null){
            doOnFalse = End.instance();
        }
        if (doOnTrue == null) {
            doOnTrue = End.instance();
        }
        return new ConditionStage(predicate, doOnTrue, doOnFalse);
    }
}
