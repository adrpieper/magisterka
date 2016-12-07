package pl.edu.ug.inf.am.trip.controller;

import android.os.Bundle;
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

    public void showTrip() {
        showSkill();
        //gameView.showFragment(new TripPagerFragment());
    }

    public void showSkill() {
        TripPagerFragment tripPagerFragment = new TripPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TripPagerFragment.SELECTED_PAGE, TripPagerFragment.SKILLS_PAGE);
        tripPagerFragment.setArguments(bundle);
        gameView.showFragment(tripPagerFragment);
    }
}
