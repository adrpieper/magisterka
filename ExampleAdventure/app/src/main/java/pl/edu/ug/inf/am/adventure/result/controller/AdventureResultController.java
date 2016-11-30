package pl.edu.ug.inf.am.adventure.result.controller;

import pl.aml.character.CharacterType;
import pl.aml.character.StatType;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.adventure.dagger.AdventureSubComponentManager;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;
import pl.edu.ug.inf.am.adventure.state.AdventureResult;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerAdventureStage
public class AdventureResultController {

    private AdventureSubComponentManager adventureSubComponentManager;
    private AdventureResult adventureResult;
    private PlayerState playerState;
    private AdventurePlayerModel playerModel;

    @Inject
    public AdventureResultController(AdventureSubComponentManager adventureSubComponentManager, AdventureResult adventureResult, PlayerState playerState, AdventurePlayerModel playerModel) {
        this.adventureSubComponentManager = adventureSubComponentManager;
        this.adventureResult = adventureResult;
        this.playerState = playerState;
        this.playerModel = playerModel;
    }

    public void acceptResult() {
        playerState.getHp().setValue(playerModel.getHp().getValue());
        playerState.getMp().setValue(playerModel.getMp().getValue());
        int gainedExp = adventureResult.getGainedExp();
        gainExp(gainedExp);
        adventureSubComponentManager.endAdventure();
    }

    private void gainExp(int gainedExp) {
        int newExp = playerState.getExperience() + gainedExp;
        playerState.setExperience(newExp);
        int newLevel = newExp/100;
        int gainedLevels = newLevel - playerState.getLevel();
        gainLevel(newLevel,gainedLevels);

    }

    private void gainLevel(int newLevel,int gainedLevels){
        if (gainedLevels > 0) {
            playerState.setSkillPoints(playerState.getSkillPoints() + playerState.getSkillPoints());
            playerState.setLevel(newLevel);
            CharacterType characterType = playerState.getCharacterType();
            Stats statsOnStart = characterType.getStatsOnStart();
            Stats statsPerLevel = characterType.getStatsPerLevel();
            int newIntelligence = count(StatType.INTELLIGENCE, statsOnStart, statsPerLevel, newLevel);
            int newStrength = count(StatType.STRENGTH, statsOnStart, statsPerLevel, newLevel);
            int newAgility = count(StatType.AGILITY, statsOnStart, statsPerLevel, newLevel);
            setStats(new Stats(newIntelligence, newStrength, newAgility));
        }
    }

    private void setStats(Stats newStats){
        playerState.setStats(newStats);
        playerState.getHp().setMaxValue(newStats.getStrength()*100);
        playerState.getMp().setMaxValue(newStats.getIntelligence()*100);

    }

    private int count (StatType statType, Stats statsOnStart, Stats statsPerLevel,int level) {
        return statsOnStart.get(statType)+level*statsPerLevel.get(statType);
    }
}
