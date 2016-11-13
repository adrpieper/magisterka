package pl.edu.ug.inf.am.player.state;

import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class PlayerState {
    private int healt = 100;
    private String name = "Edek";
    private int experience;

    @Inject
    public PlayerState() {
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getHealt() {
        return healt;
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
