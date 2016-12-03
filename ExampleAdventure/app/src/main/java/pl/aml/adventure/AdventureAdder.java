package pl.aml.adventure;

import pl.aml.adventure.factory.AdventureInstance;

public class AdventureAdder implements AStage{
    private final AdventureInstance adventureInstance;

    public AdventureAdder(AdventureInstance adventureInstance) {
        this.adventureInstance = adventureInstance;
    }

    @Override
    public void run(AdventureEngine engine) {
        engine.addAventure(adventureInstance);
    }
}
