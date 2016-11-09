package pl.aml;

public class Adventure {

    private final Location location;
    private final AStage firstStage;

    @Deprecated
    public Adventure(Location location){
        this(location, null);
    }

    public Adventure(Location location, AStage firstStage){

        this.location = location;
        this.firstStage = firstStage;
    }

    public Location getLocation() {
        return location;
    }

    public AStage getFirstStage() {
        return firstStage;
    }
}
