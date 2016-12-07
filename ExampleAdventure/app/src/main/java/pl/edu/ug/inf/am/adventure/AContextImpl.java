package pl.edu.ug.inf.am.adventure;

import pl.aml.character.FightValues;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

import javax.inject.Inject;

@PerAdventure
public class AContextImpl implements FightValues {

    private final AdventurePlayerModel player;

    @Inject
    public AContextImpl(AdventurePlayerModel player) {
        this.player = player;
    }

    @Override
    public int playerLvl() {
        return player.getLevel();
    }

    @Override
    public int playerInt() {
        return player.getStats().getIntelligence();
    }

    @Override
    public int playerStr() {
        return player.getStats().getStrength();
    }

    @Override
    public int playerAgi() {
        return player.getStats().getAgility();
    }
}
