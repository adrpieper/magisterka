package pl.aml.adventure;

public class AdventureAdder extends AbsAState{
    private final AdventureInstance adventureInstance;

    public AdventureAdder(AdventureInstance adventureInstance) {
        this.adventureInstance = adventureInstance;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.addAdventure(adventureInstance);
    }
}
