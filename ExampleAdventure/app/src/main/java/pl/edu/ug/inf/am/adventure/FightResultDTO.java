package pl.edu.ug.inf.am.adventure;

public class FightResultDTO {
    public final int enemyHp;
    public final int playerHp;

    public FightResultDTO(int enemyHp, int playerHp) {
        this.enemyHp = enemyHp;
        this.playerHp = playerHp;
    }
}

