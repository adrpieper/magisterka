package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.aml.adventure.AStage;
import pl.aml.adventure.AdventureEngine;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.view.ResultFragment;
import pl.edu.ug.inf.am.adventure.fight.view.FightFragment;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;

@PerAdventureStage
public class FightNavigator {

    private final GameView gameView;
    private final AdventureEngine adventureEngine;
    private AStage doOnWin;
    private AStage doOnLost;

    @Inject
    public FightNavigator(GameView gameView, AdventureEngine adventureEngine) {
        this.gameView = gameView;
        this.adventureEngine = adventureEngine;
    }

    public void showResult() {
        gameView.showFragment(new ResultFragment());
    }

    public void showFight() {
        gameView.showFragment(new FightFragment());
    }

    public void goToWinStage() {
        doOnLost.run(adventureEngine);
    }

    public void goToLostStage() {
        doOnLost.run(adventureEngine);
    }

    public void setAfterFightStages(AStage doOnWin, AStage doOnLost) {

        this.doOnWin = doOnWin;
        this.doOnLost = doOnLost;
    }
}
