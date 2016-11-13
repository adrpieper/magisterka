package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.view.WinFragment;
import pl.edu.ug.inf.am.adventure.fight.view.FightFragment;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;

@PerAdventureStage
public class FightNavigator {

    private final FightComponent fightComponent;
    private final GameView gameView;

    @Inject
    public FightNavigator(FightComponent fightComponent, GameView gameView) {
        this.fightComponent = fightComponent;
        this.gameView = gameView;
    }

    public void showWin() {
        WinFragment winFragment = new WinFragment();
        fightComponent.inject(winFragment);
        gameView.showFragment(winFragment);
    }

    public void showFight() {
        FightFragment fightFragment = new FightFragment();
        fightComponent.inject(fightFragment);
        gameView.showFragment(fightFragment);
    }
}
