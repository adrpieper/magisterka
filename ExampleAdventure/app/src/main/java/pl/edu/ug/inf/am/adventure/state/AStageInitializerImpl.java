package pl.edu.ug.inf.am.adventure.state;

import pl.aml.*;
import pl.edu.ug.inf.am.GameStageStateProvider;

public class AStageInitializerImpl implements AStageInitializer {

    private final GameStageStateProvider stateProvider;

    public AStageInitializerImpl(GameStageStateProvider stateProvider) {
        this.stateProvider = stateProvider;
    }

    @Override
    public void init(AFight aFight) {
        final FightState state = new FightState(aFight.getOpponents());
        final MonsterType actualMonster = state.getMonstersToKill().get(0);
        state.setActualMonster(actualMonster);
        state.setEnemyHealth(actualMonster.getHp());
        stateProvider.getAdventureState().setState(state);
    }

    @Override
    public void init(End end) {

    }

    @Override
    public void init(Question question) {

    }
}
