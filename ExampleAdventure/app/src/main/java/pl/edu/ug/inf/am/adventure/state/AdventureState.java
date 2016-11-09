package pl.edu.ug.inf.am.adventure.state;

import pl.aml.AStage;
import pl.edu.ug.inf.am.stage.StageState;

public class AdventureState extends StageState {
    private AStage AStage;
    private AStageState state;

    public void setState(AStageState state) {
        this.state = state;
    }

    public <T extends AStageState> T getState() {
        return (T) state;
    }

    public void setAStage(pl.aml.AStage AStage) {
        this.AStage = AStage;
    }

    public <T extends AStage> T getAStage() {
        return (T) AStage;
    }
}
