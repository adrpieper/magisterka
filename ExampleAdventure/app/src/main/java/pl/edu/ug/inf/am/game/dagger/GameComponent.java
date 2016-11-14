package pl.edu.ug.inf.am.game.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.common.HasSubComponents;
import pl.edu.ug.inf.am.game.view.GameViewContainer;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;

@PerGame
@Subcomponent(modules = {GameViewModule.class})
public interface GameComponent extends HasSubComponents {

    TripComponent tripComponent();
    AdventureComponent adventureComponent();
    GameViewContainer gameViewContainer();
    GameSubComponentManager subComponentsManager();

}
