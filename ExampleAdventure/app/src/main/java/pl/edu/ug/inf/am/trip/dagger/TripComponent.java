package pl.edu.ug.inf.am.trip.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.gps.GPS;
import pl.edu.ug.inf.am.nfc.NFC;
import pl.edu.ug.inf.am.trip.controller.TripManager;
import pl.edu.ug.inf.am.trip.location.GPSListenerImpl;
import pl.edu.ug.inf.am.trip.location.NFCListener;
import pl.edu.ug.inf.am.trip.controller.TripNavigator;
import pl.edu.ug.inf.am.trip.items.ItemsFragment;
import pl.edu.ug.inf.am.trip.view.LocationSelectFragment;
import pl.edu.ug.inf.am.trip.view.PlayerReviewFragment;
import pl.edu.ug.inf.am.trip.skills.SkillsFragment;

@PerTrip
@Subcomponent(modules = LocationModule.class)
public interface TripComponent {

    TripNavigator tripNavigator();
    TripManager tripManager();
    void inject(LocationSelectFragment locationSelectFragment);
    void inject(PlayerReviewFragment playerReviewFragment);
    void inject(SkillsFragment skillsFragment);
    void inject(ItemsFragment itemsFragment);
}
