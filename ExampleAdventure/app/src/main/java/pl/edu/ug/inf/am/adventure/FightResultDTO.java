package pl.edu.ug.inf.am.adventure;

import pl.edu.ug.inf.am.adventure.state.FightState;

public class FightResultDTO {
    public final int enemyHp;
    public final int playerHp;
    public final FightState.Result result;

    public FightResultDTO(int enemyHp, int playerHp, FightState.Result result) {
        this.enemyHp = enemyHp;
        this.playerHp = playerHp;
        this.result = result;
    }
}

