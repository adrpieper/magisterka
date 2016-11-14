package pl.edu.ug.inf.am.game.dagger;

import pl.aml.Adventure;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;

import javax.inject.Inject;

@PerGame
public class GameSubComponentManager extends SubComponentManager {

    private final GameComponent gameComponent;

    @Inject
    public GameSubComponentManager(ComponentsManager componentsManager, GameComponent gameComponent) {
        super(componentsManager);
        this.gameComponent = gameComponent;
    }

    public void startTrip() {
        TripComponent component = gameComponent.tripComponent();
        setSubcomponent(TripComponent.class, component);
        component.tripNavigator().showTrip();
    }

    public void startAdventure(Adventure adventure) {
        AdventureComponent adventureComponent = gameComponent.adventureComponent();
        setSubcomponent(AdventureComponent.class, adventureComponent);
        adventure.getFirstStage().run(adventureComponent.adventureEngine());
    }
}