package pl.aml.adventure;

/**
 * Created by Adi on 2017-04-18.
 */
public abstract class AbsAState implements AStage, AStageBuilder{

    @Override
    public AStage build() {
        return this;
    }
}
