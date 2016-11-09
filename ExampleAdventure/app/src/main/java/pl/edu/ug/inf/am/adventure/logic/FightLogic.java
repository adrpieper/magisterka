package pl.edu.ug.inf.am.adventure.logic;

import pl.edu.ug.inf.am.adventure.FightResultDTO;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FightLogic {

    @Inject
    public FightLogic() {
    }

    public FightResultDTO fight(FightState fightState, PlayerState playerState){
        return new FightResultDTO(0,100);
    }
}
