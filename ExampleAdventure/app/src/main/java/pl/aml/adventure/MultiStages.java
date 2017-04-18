package pl.aml.adventure;

import java.util.Arrays;

public class MultiStages extends AbsAState{

    private AStage[] stages;

    MultiStages(AStage... stages) {
        this.stages = stages;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.addStages(Arrays.asList(stages));
    }

}
