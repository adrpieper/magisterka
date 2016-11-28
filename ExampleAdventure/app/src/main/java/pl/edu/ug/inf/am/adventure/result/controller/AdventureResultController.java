package pl.edu.ug.inf.am.adventure.result.controller;

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
        playerState.setExperience(playerState.getExperience() + adventureResult.getGainedExp());
        adventureSubComponentManager.endAdventure();
    }
}
