package pl.aml.character;

import android.databinding.Bindable;
import pl.aml.impl.character.SkillType;

public class SkillNode {
    private final SkillType skillType;
    private final SkillNode[] unlockedSkills;
    private SkillType parent;

    public SkillNode(SkillType skillType, SkillNode... unlockedSkills) {
        this.skillType = skillType;
        this.unlockedSkills = unlockedSkills;
    }

    public SkillNode(SkillType skillType, SkillType parent, SkillNode... unlockedSkills) {
        this.skillType = skillType;
        this.parent = parent;
        this.unlockedSkills = unlockedSkills;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public SkillNode[] getUnlockedSkills() {
        return unlockedSkills;
    }

    @Override
    public String toString() {
        return skillType.name();
    }

    public SkillType getParent() {
        return parent;
    }
}
