package pl.aml;

public class Adventure {

    private final Location location;
    private final Monster[] monsters;

    public Adventure(Location location, Monster... monsters){

        this.location = location;
        this.monsters = monsters;
    }

    public Location getLocation() {
        return location;
    }

    public Monster[] getMonsters() {
        return monsters;
    }
}
