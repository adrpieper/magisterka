package pl.aml.character;

public class SkillNode {
    private final SkillType skillType;
    private final SkillNode[] unlockedSkills;

    public SkillNode(SkillType skillType, SkillNode... unlockedSkills) {
        this.skillType = skillType;
        this.unlockedSkills = unlockedSkills;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public SkillNode[] getUnlockedSkills() {
        return unlockedSkills;
    }
}
