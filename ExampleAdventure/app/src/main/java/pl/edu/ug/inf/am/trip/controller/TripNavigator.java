package pl.edu.ug.inf.am.trip.controller;

import pl.edu.ug.inf.am.game.view.GameView;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;
import pl.edu.ug.inf.am.trip.view.LocationSelectFragment;
import pl.edu.ug.inf.am.trip.view.PlayerReviewFragment;
import pl.edu.ug.inf.am.trip.view.TripFragment;

import javax.inject.Inject;

@PerTrip
public class TripNavigator {

    private final TripComponent tripComponent;
    private final GameView gameView;

    @Inject
    public TripNavigator(TripComponent tripComponent, GameView gameView) {
        this.tripComponent = tripComponent;
        this.gameView = gameView;
    }

    public void showLocations() {
        LocationSelectFragment locationSelectFragment = new LocationSelectFragment();
        tripComponent.inject(locationSelectFragment);
        gameView.showFragment(locationSelectFragment);
    }

    public void showPlayer() {
        PlayerReviewFragment playerReviewFragment = new PlayerReviewFragment();
        tripComponent.inject(playerReviewFragment);
        gameView.showFragment(playerReviewFragment);
    }

    public void backToTrip(){
        TripFragment tripFragment = new TripFragment();
        tripComponent.inject(tripFragment);
        gameView.showFragment(tripFragment);
    }

    public void showTrip() {

        TripFragment tripFragment = new TripFragment();
        tripComponent.inject(tripFragment);
        gameView.showFragment(tripFragment);
    }
}
