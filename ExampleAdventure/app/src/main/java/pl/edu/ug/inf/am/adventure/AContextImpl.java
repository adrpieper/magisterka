package pl.edu.ug.inf.am.adventure;

import pl.aml.adventure.AContext;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

public class AContextImpl implements AContext {

    private final AdventurePlayerModel player;

    public AContextImpl(AdventurePlayerModel player) {
        this.player = player;
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
