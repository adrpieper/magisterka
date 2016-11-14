package pl.edu.ug.inf.am.player.state;

import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class PlayerState {
    private final BarState hp = new BarState(200);
    private final BarState mp = new BarState(100);
    private String name = "Edek";
    private int experience;

    @Inject
    public PlayerState() {
    }

    public BarState getHp() {
        return hp;
    }

    public BarState getMp() {
        return mp;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

}
