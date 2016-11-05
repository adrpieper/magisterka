package pl.edu.ug.inf.am.player.model;

import android.databinding.ObservableInt;
import pl.edu.ug.inf.am.player.state.PlayerState;

public class PlayerModel {

    public final ObservableInt hp = new ObservableInt();;
    private final int power;
    private final String name;

    public PlayerModel(PlayerState playerState) {
        this.hp.set(playerState.getHealt());
        this.power = 1;
        this.name = playerState.getName();
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}
