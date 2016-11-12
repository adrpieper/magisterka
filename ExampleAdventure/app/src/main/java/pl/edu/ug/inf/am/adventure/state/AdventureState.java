package pl.edu.ug.inf.am.adventure.state;

import pl.aml.AStage;
import pl.edu.ug.inf.am.stage.StageState;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class AdventureState extends StageState {
    private AStageState state;
    private Stack<AStage> stagesStack = new Stack<>();

    public void setState(AStageState state) {
        this.state = state;
    }

    public <T extends AStageState> T getState() {
        return (T) state;
    }

    public void addStages(Collection<AStage> stageFactories){
        for (AStage stage : stageFactories) {
            stagesStack.push(stage);
        }
    }

    public Stack<AStage> getStagesStack() {
        return stagesStack;
    }
}
