package pl.edu.ug.inf.am.trip.controller;

import pl.edu.ug.inf.am.game.view.GameView;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.view.LocationSelectFragment;
import pl.edu.ug.inf.am.trip.view.PlayerReviewFragment;
import pl.edu.ug.inf.am.trip.view.TripFragment;

import javax.inject.Inject;

@PerTrip
public class TripNavigator {

    private final GameView gameView;

    @Inject
    public TripNavigator(GameView gameView) {
        this.gameView = gameView;
    }

    public void showLocations() {
        gameView.showFragment(new LocationSelectFragment());
    }

    public void showPlayer() {
        gameView.showFragment(new PlayerReviewFragment());
    }

    public void showTrip() {
        gameView.showFragment(new TripFragment());
    }
}
