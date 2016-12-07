package pl.edu.ug.inf.am.trip.controller;

import pl.edu.ug.inf.am.game.view.GameView;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.view.TripPagerFragment;

import javax.inject.Inject;

@PerTrip
public class TripNavigator {

    private final GameView gameView;

    @Inject
    public TripNavigator(GameView gameView) {
        this.gameView = gameView;
    }

    public void showLocations() {
        gameView.showFragment(new TripPagerFragment());
    }

    public void showPlayer() {
        gameView.showFragment(new TripPagerFragment());
    }

    public void showTrip() {
        gameView.showFragment(new TripPagerFragment());
    }

    public void showSkill() {
        gameView.showFragment(new TripPagerFragment());
    }

    public void showItems() {
        gameView.showFragment(new TripPagerFragment());
    }
}
