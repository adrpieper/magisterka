package pl.edu.ug.inf.am.game.player;

import pl.aml.impl.character.CharacterType;
import pl.aml.character.StatType;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class BasicStatsGenerator {

    @Inject
    public BasicStatsGenerator() {
    }

    public Stats generate(int level, CharacterType characterType) {
        Stats statsOnStart = characterType.getStatsOnStart();
        Stats statsPerLevel = characterType.getStatsPerLevel();
        int newIntelligence = count(StatType.INTELLIGENCE, statsOnStart, statsPerLevel, level);
        int newStrength = count(StatType.STRENGTH, statsOnStart, statsPerLevel, level);
        int newAgility = count(StatType.AGILITY, statsOnStart, statsPerLevel, level);
        return new Stats(newIntelligence, newStrength, newAgility);
    }

    private int count (StatType statType, Stats statsOnStart, Stats statsPerLevel,int level) {
        return statsOnStart.get(statType)+level*statsPerLevel.get(statType);
    }
}
