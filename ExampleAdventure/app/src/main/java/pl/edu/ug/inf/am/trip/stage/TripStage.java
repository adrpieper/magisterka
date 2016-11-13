package pl.edu.ug.inf.am.trip.stage;

import pl.edu.ug.inf.am.common.StageLifecycle;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.controller.TripNavigator;

import javax.inject.Inject;

@PerTrip
public class TripStage implements StageLifecycle<Void> {

    private final TripNavigator tripNavigator;

    @Inject
    public TripStage(TripNavigator tripNavigator) {
        this.tripNavigator = tripNavigator;
    }

    @Override
    public void onStart(Void aVoid) {
        tripNavigator.showTrip();
    }

    @Override
    public void onResume() {
        tripNavigator.showTrip();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onEnd() {

    }
}
