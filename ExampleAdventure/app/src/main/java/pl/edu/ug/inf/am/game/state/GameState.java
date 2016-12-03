package pl.edu.ug.inf.am.game.state;

import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GameState {

    private State state;

    @Inject
    public GameState() {
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public enum State {
        CREATED,
        CONTINUED,
        RUNNING;
    }
}
