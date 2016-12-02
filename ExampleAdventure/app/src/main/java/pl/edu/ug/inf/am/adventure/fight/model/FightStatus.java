package pl.edu.ug.inf.am.adventure.fight.model;

public enum FightStatus {
    WIN(true),
    LOST(true),
    ENEMY_KILLED(false),
    ENEMY_TURN(false),
    PLAYER_TURN(false);

    private final boolean isEnd;

    FightStatus(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
