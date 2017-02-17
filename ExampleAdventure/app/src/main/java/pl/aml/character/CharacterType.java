package pl.aml.character;

import pl.aml.character.SkillTree;
import pl.aml.character.Stats;

public class CharacterType {
    private final String name;
    private final Stats statsOnStart;
    private final Stats statsPerLevel;
    private final SkillTree skillTree;

    public CharacterType(String name, Stats statsOnStart, Stats statsPerLevel, SkillTree skillTree) {
        this.name = name;
        this.statsOnStart = statsOnStart;
        this.statsPerLevel = statsPerLevel;
        this.skillTree = skillTree;
    }

    public String getName() {
        return name;
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
