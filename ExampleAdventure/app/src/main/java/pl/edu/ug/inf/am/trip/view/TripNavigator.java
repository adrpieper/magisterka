package pl.edu.ug.inf.am.trip.view;

import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.view.GameActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TripNavigator {

    private final DiComponent diComponent;
    private final GameActivity gameActivity;

    @Inject
    public TripNavigator(DiComponent diComponent, GameActivity gameActivity) {
        this.diComponent = diComponent;
        this.gameActivity = gameActivity;
    }

    public void showLocations() {
        LocationSelectFragment locationSelectFragment = new LocationSelectFragment();
        diComponent.inject(locationSelectFragment);
        gameActivity.showFragment(locationSelectFragment);
    }

    public void showPlayer() {
        PlayerReviewFragment playerReviewFragment = new PlayerReviewFragment();
        diComponent.inject(playerReviewFragment);
        gameActivity.showFragment(playerReviewFragment);
    }

    public void backToTrip(){
        TripFragment tripFragment = new TripFragment();
        diComponent.inject(tripFragment);
        gameActivity.showFragment(tripFragment);
    }
}
