package pl.edu.ug.inf.am.adventure.controller;

import pl.aml.AStage;
import pl.aml.AStageDisplayer;
import pl.aml.AStageInitializer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdventureStageStarter {

    private final AStageDisplayer aStageDisplayer;
    private final AStageInitializer stageInitializer;

    @Inject
    public AdventureStageStarter(AStageDisplayer aStageDisplayer, AStageInitializer stageInitializer) {
        this.aStageDisplayer = aStageDisplayer;
        this.stageInitializer = stageInitializer;
    }

    public void start(AStage aStage) {
        aStage.init(stageInitializer);
        aStage.show(aStageDisplayer);
    }
}
