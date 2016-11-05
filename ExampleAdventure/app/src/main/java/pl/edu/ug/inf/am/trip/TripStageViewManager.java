package pl.edu.ug.inf.am.trip;

import pl.edu.ug.inf.am.trip.state.TripState;
import pl.edu.ug.inf.am.trip.view.TripNavigator;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.view.StageViewManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TripStageViewManager implements StageViewManager<TripState> {

    private final TripNavigator tripNavigator;

    @Inject
    public TripStageViewManager(TripNavigator tripNavigator) {
        this.tripNavigator = tripNavigator;
    }

    @Override
    public void showState(TripState state, GameActivity gameActivity) {
        tripNavigator.backToTrip();
    }
}
