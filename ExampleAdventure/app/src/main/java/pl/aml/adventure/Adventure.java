package pl.aml.adventure;

public class Adventure {

    private final AStage firstStage;

    public Adventure(AStage firstStage){
        this.firstStage = firstStage;
    }

    public AStage getFirstStage() {
        return firstStage;
    }
}
