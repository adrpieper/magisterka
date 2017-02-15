package pl.aml.character;

import pl.aml.character.SkillTree;
import pl.aml.character.Stats;

public class CharacterType {
    private final Stats statsOnStart;
    private final Stats statsPerLevel;
    private final SkillTree skillTree;

    public CharacterType(Stats statsOnStart, Stats statsPerLevel, SkillTree skillTree) {
        this.statsOnStart = statsOnStart;
        this.statsPerLevel = statsPerLevel;
        this.skillTree = skillTree;
    }

    public Stats getStatsPerLevel() {
        return statsPerLevel;
    }

    public Stats getStatsOnStart() {
        return statsOnStart;
    }

    public SkillTree getSkillTree() {
        return skillTree;
    }
}
