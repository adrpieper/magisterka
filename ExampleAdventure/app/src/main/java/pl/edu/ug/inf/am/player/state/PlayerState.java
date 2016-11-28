package pl.edu.ug.inf.am.player.state;

import pl.aml.character.CharacterType;
import pl.aml.character.SkillType;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@PerGame
public class PlayerState {
    private final BarState hp = new BarState(200);
    private final BarState mp = new BarState(100);
    private final CharacterType characterType;
    private final Set<SkillType> unlockedSkills = new HashSet<>();
    private String name = "Edek";
    private int experience;
    private int level = 1;
    private int skillPoints;
    private Stats stats;

    public PlayerState(CharacterType characterType) {
        this.characterType = characterType;
    }

    public void addSkill(SkillType skillType) {
        unlockedSkills.add(skillType);
    }

    public Set<SkillType> getUnlockedSkills() {
        return unlockedSkills;
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

    public void addSkillPoints(int skillPoints) {
        this.skillPoints += skillPoints;
    }

    public void removeSkillPoints(int skillPoints) {
        this.skillPoints -= skillPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }
}
