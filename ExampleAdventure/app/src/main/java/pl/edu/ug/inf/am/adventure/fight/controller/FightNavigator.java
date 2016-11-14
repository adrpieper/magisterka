package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.view.WinFragment;
import pl.edu.ug.inf.am.adventure.fight.view.FightFragment;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;

@PerAdventureStage
public class FightNavigator {

    private final GameView gameView;

    @Inject
    public FightNavigator(GameView gameView) {
        this.gameView = gameView;
    }

    public void showWin() {
        gameView.showFragment(new WinFragment());
    }

    public void showFight() {
        gameView.showFragment(new FightFragment());
    }
}
