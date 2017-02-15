package pl.edu.ug.inf.am.trip.skills;

import pl.aml.character.SkillNode;
import pl.aml.impl.character.SkillType;
import pl.edu.ug.inf.am.trip.controller.TripNavigator;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.skills.model.SkillsModel;

import javax.inject.Inject;

@PerTrip
public class SkillsController {

    private final SkillsModel skillsModel;
    private final TripNavigator tripNavigator;

    @Inject
    public SkillsController(SkillsModel skillsModel, TripNavigator tripNavigator) {
        this.skillsModel = skillsModel;
        this.tripNavigator = tripNavigator;
    }

    public boolean canUnlock(SkillNode skillNode) {
        return skillsModel.getSkillsPoints() > 0 &&
                hasParentUnlocked(skillNode) &&
                !skillsModel.getSkills().contains(skillNode.getSkillType());
    }

    public void unlockSkill(SkillNode skillNode) {
        if (canUnlock(skillNode)) {
            skillsModel.removeSkillPoint();
            skillsModel.addSkill(skillNode.getSkillType());
        }
    }

    public void reset() {
        skillsModel.reset();
    }

    private boolean hasParentUnlocked(SkillNode skillNode) {
        SkillType parent = skillNode.getParent();
        return parent == null || skillsModel.getSkills().contains(parent);
    }

    public void accept() {
        skillsModel.accept();
        tripNavigator.showTrip();
    }
}
