package pl.aml.character;

public class CharacterTypeBuilder {
    private Stats statsOnStart;
    private Stats statsPerLevel;
    private SkillTree skillTree;
    private String name;

    public CharacterTypeBuilder statsOnStart(int strength, int intelligence, int agility) {
        this.statsOnStart = new Stats(intelligence,strength,agility);
        return this;
    }

    public CharacterTypeBuilder statsPerLevel(int strength, int intelligence, int agility) {
        this.statsPerLevel = new Stats(intelligence,strength,agility);;
        return this;
    }

    public CharacterTypeBuilder skills(SkillNode... skillNodes) {
        this.skillTree = new SkillTree(skillNodes);
        return this;
    }

    public CharacterType createCharacterType() {
        return new CharacterType(name, statsOnStart, statsPerLevel, skillTree);
    }

    public CharacterTypeBuilder name(String name) {
        this.name = name;
        return this;
    }
}