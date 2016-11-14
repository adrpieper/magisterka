package pl.edu.ug.inf.am.adventure.model;

import android.databinding.BaseObservable;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerAdventure
public class AdventurePlayerModel extends BaseObservable {

    private final BarModel hp;
    private final BarModel mp;
    private final PlayerState playerState;

    @Inject
    public AdventurePlayerModel(PlayerState playerState) {
        this.playerState = playerState;
        hp = new BarModel(playerState.getHp());
        mp = new BarModel(playerState.getMp());
    }

    public BarModel getHp() {
        return hp;
    }

    public BarModel getMp() {
        return mp;
    }

    public String getName() {
        return playerState.getName();
    }

    public void setHp(int hp) {
        this.hp.setValue(hp);
    }
}
