package pl.aml.adventure;

import pl.aml.Location;

public class Adventure {

    private final AStage firstStage;

    public Adventure(AStage firstStage){
        this.firstStage = firstStage;
    }

    @Deprecated
    public Adventure(Location forrest) {
        firstStage = End.instance();
    }

    public AStage getFirstStage() {
        return firstStage;
    }
}
