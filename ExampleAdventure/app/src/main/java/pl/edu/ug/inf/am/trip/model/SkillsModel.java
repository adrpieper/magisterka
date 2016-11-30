package pl.edu.ug.inf.am.trip.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.character.SkillType;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;

import javax.inject.Inject;
import java.util.EnumSet;
import java.util.Set;

@PerTrip
public class SkillsModel extends BaseObservable{

    private Set<SkillType> skills;
    private final PlayerState playerState;
    private int skillsPoints;

    @Inject
    public SkillsModel(PlayerState playerState){
        this.playerState = playerState;
        reset();
    }

    @Bindable
    public Set<SkillType> getSkills() {
        return skills;
    }

    @Bindable
    public int getSkillsPoints() {
        return skillsPoints;
    }

    public void addSkill(SkillType skillType) {
        skills.add(skillType);
        notifyPropertyChanged(BR.skills);
    }

    public void removeSkillPoint() {
        skillsPoints--;
        notifyPropertyChanged(BR.skillsPoints);
    }

    public void reset() {
        setSkillsPoints(playerState.getSkillPoints());
        setSkills(playerState.getSkills());
    }

    public void accept() {
        playerState.setSkillPoints(skillsPoints);
        playerState.setSkills(skills);
    }

    private void setSkillsPoints(int skillsPoints) {
        this.skillsPoints = skillsPoints;
        notifyPropertyChanged(BR.skillsPoints);
    }

    private void setSkills(Set<SkillType> skills) {
        this.skills = EnumSet.copyOf(skills);
        notifyPropertyChanged(BR.skills);
    }
}
