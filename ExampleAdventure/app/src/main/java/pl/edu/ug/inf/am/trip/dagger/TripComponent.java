package pl.edu.ug.inf.am.trip.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.trip.controller.TripNavigator;
import pl.edu.ug.inf.am.trip.items.ItemsFragment;
import pl.edu.ug.inf.am.trip.view.LocationSelectFragment;
import pl.edu.ug.inf.am.trip.view.PlayerReviewFragment;
import pl.edu.ug.inf.am.trip.skills.SkillsFragment;
import pl.edu.ug.inf.am.trip.view.TripFragment;

@PerTrip
@Subcomponent()
public interface TripComponent {

    TripNavigator tripNavigator();
    void inject(LocationSelectFragment locationSelectFragment);
    void inject(PlayerReviewFragment playerReviewFragment);
    void inject(TripFragment tripFragment);

    void inject(SkillsFragment skillsFragment);

    void inject(ItemsFragment itemsFragment);
}
