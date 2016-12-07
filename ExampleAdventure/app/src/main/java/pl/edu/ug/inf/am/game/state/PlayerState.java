package pl.edu.ug.inf.am.game.state;

import pl.aml.character.CharacterType;
import pl.aml.character.SkillType;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import java.util.EnumSet;
import java.util.Set;

@PerGame
public class PlayerState {
    private final BarState hp = new BarState(200);
    private final BarState mp = new BarState(100);
    private final CharacterType characterType;
    private final Set<SkillType> skills = EnumSet.noneOf(SkillType.class);
    private String name = "Edek";
    private int experience;
    private int level = 1;
    private int skillPoints;
    private final PlayerStatsState stats = new PlayerStatsState();
    private final ItemsState itemsState = new ItemsState();

    public PlayerState(CharacterType characterType) {
        this.characterType = characterType;
    }

    public Set<SkillType> getSkills() {
        return skills;
    }

    public CharacterType getCharacterType() {
        return characterType;
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

    public int getLevel() {
        return level;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PlayerStatsState getStats() {
        return stats;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public void setSkills(Set<SkillType> skills) {
        this.skills.clear();
        this.skills.addAll(skills);
    }

    public ItemsState getItemsState() {
        return itemsState;
    }
}
