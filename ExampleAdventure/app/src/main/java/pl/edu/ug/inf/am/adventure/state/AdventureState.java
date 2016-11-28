package pl.edu.ug.inf.am.adventure.state;

import pl.aml.adventure.AStage;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Stack;

@PerAdventure
public class AdventureState {
    private Stack<AStage> stagesStack = new Stack<>();

    @Inject
    public AdventureState() {}

    public void addStages(Collection<AStage> stageFactories){
        for (AStage stage : stageFactories) {
            stagesStack.push(stage);
        }
    }

    public AStage popFirstStage() {
        return stagesStack.pop();
    }

    public boolean hasMoreStages() {
        return !stagesStack.isEmpty();
    }
}
