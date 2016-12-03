package pl.aml.adventure;

import pl.aml.Location;

/**
 * Created by adrian on 07.11.16.
 */
public class AdventureBuilder {

    private Location location;
    private AStage firstStage;

    public AdventureBuilder() {
        this.location = location;
    }

    public AdventureBuilder in(Location location) {
        this.location = location;
        return this;
    }

    public AdventureBuilder startsFrom(AStageBuilder aStageBuilder) {
        return startsFrom(aStageBuilder.build());
    }

    public AdventureBuilder startsFrom(AStage firstStage) {
        this.firstStage = firstStage;
        return this;
    }

    public Adventure build(){
        return new Adventure(location, firstStage);
    }
}
