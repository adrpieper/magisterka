package pl.edu.ug.inf.am.adventure.fight.stage;

import pl.edu.ug.inf.am.adventure.fight.controller.FightNavigator;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.common.StageLifecycle;

import javax.inject.Inject;

@PerAdventureStage
public class FightStage implements StageLifecycle<Void> {

    private final FightNavigator fightNavigator;
    private final FightState fightState;

    @Inject
    public FightStage(FightNavigator fightNavigator, FightState fightState) {
        this.fightNavigator = fightNavigator;
        this.fightState = fightState;
    }

    @Override
    public void onStart(Void aVoid) {
        fightNavigator.showFight();
    }

    @Override
    public void onResume() {
        if (fightState.getResult().isEnd()) {
            fightNavigator.showFight();
        }else {
            fightNavigator.showWin();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onEnd() {

    }
}
