package pl.edu.ug.inf.am.player.state;

/**
 * Created by Adi on 2016-11-02.
 */
public class PlayerState {
    private int healt = 100;
    private String name = "Edek";
    private int experience;

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
