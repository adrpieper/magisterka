package pl.edu.ug.inf.am.adventure.stage;

import pl.aml.Adventure;
import pl.aml.AdventureEngine;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.common.StageLifecycle;

import javax.inject.Inject;

@PerAdventure
public class AdventureStage implements StageLifecycle<Adventure> {

    private final AdventureStagesManager adventureStagesManager;
    private final AdventureEngine adventureEngine;

    @Inject
    public AdventureStage(AdventureStagesManager adventureStagesManager, AdventureEngine adventureEngine) {
        this.adventureStagesManager = adventureStagesManager;
        this.adventureEngine = adventureEngine;
    }

    @Override
    public void onStart(Adventure adventure) {
        adventure.getFirstStage().run(adventureEngine);
    }

    @Override
    public void onResume() {
        adventureStagesManager.onResume();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onEnd() {

    }
}
