package pl.aml.adventure;

public class AdventureRemover extends AbsAState {
    private final AdventureInstance adventureInstance;

    public AdventureRemover(AdventureInstance adventureInstance) {
        this.adventureInstance = adventureInstance;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.removeAdventure(adventureInstance);
    }
}
