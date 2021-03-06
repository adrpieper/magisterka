package pl.edu.ug.inf.am.adventure.model;

import android.databinding.BaseObservable;
import pl.aml.impl.character.SkillType;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.game.state.PlayerState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;

import javax.inject.Inject;
import java.util.Set;

@PerAdventure
public class AdventurePlayerModel extends BaseObservable {

    private final BarModel hp;
    private final BarModel mp;
    private final Stats stats;
    private final PlayerState playerState;

    @Inject
    public AdventurePlayerModel(PlayerState playerState) {
        this.playerState = playerState;
        hp = new BarModel(playerState.getHp());
        mp = new BarModel(playerState.getMp());
        this.stats = playerState.getStats().getFull();
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

    public int getLevel() {
        return playerState.getLevel();
    }
    public void setHp(int hp) {
        this.hp.setValue(hp);
    }

    public Stats getStats() {
        return stats;
    }



    public Set<SkillType> getSkills() {
        return playerState.getSkills();
    }
}
