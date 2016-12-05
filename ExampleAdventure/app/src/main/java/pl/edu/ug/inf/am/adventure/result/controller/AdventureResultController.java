package pl.edu.ug.inf.am.adventure.result.controller;

import pl.edu.ug.inf.am.adventure.dagger.AdventureSubComponentManager;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.result.view.LevelAchievedFragment;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;

@PerAdventureStage
public class AdventureResultController {

    private final AdventureSubComponentManager adventureSubComponentManager;
    private final ResultApplier resultApplier;
    private final GameView gameView;

    @Inject
    public AdventureResultController(AdventureSubComponentManager adventureSubComponentManager, ResultApplier resultApplier, GameView gameView) {
        this.adventureSubComponentManager = adventureSubComponentManager;
        this.resultApplier = resultApplier;
        this.gameView = gameView;
    }

    public void acceptResult() {
        resultApplier.acceptResult();
        if (resultApplier.isResultAchieved()){
            gameView.showFragment(new LevelAchievedFragment());
        }else {
            adventureSubComponentManager.endAdventure();
        }
    }

    public void acceptLevelAchieved() {
        adventureSubComponentManager.endAdventure();
    }
}
