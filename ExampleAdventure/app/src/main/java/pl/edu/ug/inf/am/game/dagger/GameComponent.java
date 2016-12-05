package pl.edu.ug.inf.am.game.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.common.HasSubComponents;
import pl.edu.ug.inf.am.game.logic.GameInitializer;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.game.view.GameViewContainer;
import pl.edu.ug.inf.am.gps.view.GPSSwitch;
import pl.edu.ug.inf.am.nfc.view.NFCFragment;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;

@PerGame
@Subcomponent(modules = {GameContextModule.class, GameDataModule.class})
public interface GameComponent extends HasSubComponents {

    GameInitializer gameInitializer();
    TripComponent tripComponent();
    AdventureComponent adventureComponent();
    GameViewContainer gameViewContainer();
    GameSubComponentManager subComponentsManager();

    void inject(GPSSwitch gpsSwitch);

    void inject(NFCFragment nfcFragment);

    void inject(GameActivity gameActivity);
}
