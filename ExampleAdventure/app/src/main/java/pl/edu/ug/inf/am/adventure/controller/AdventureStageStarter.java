package pl.edu.ug.inf.am.adventure.controller;

import pl.aml.AStage;
import pl.aml.AdventureEngine;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdventureStageStarter {

    private final AdventureStateManager stateManager;
    private final AdventureEngine stageInitializer;

    @Inject
    public AdventureStageStarter(AdventureStateManager stateManager, AdventureEngine stageInitializer) {
        this.stateManager = stateManager;
        this.stageInitializer = stageInitializer;
    }

    public void start(AStage aStage) {

    }
}
