package pl.aml;

import java.util.Arrays;

public class MultiStages implements AStage{

    private AStage[] stages;

    MultiStages(AStage[] stages) {
        this.stages = stages;
    }

    @Override
    public void run(AdventureEngine initializer) {
        initializer.addStages(Arrays.asList(stages));
    }

}
