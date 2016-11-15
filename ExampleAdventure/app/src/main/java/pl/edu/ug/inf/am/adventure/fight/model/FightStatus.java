package pl.edu.ug.inf.am.adventure.fight.model;

public enum FightStatus {
    WIN(true),
    LOST(true),
    ENEMY_KILLED(false),
    FIGHT(false);

    private final boolean isEnd;

    FightStatus(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
