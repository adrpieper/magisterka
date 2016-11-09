package pl.edu.ug.inf.am.app.dagger;

import dagger.Component;
import pl.edu.ug.inf.am.adventure.WinFragment;
import pl.edu.ug.inf.am.adventure.view.FightFragment;
import pl.edu.ug.inf.am.adventure.view.QuestionFragment;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.trip.view.PlayerReviewFragment;
import pl.edu.ug.inf.am.trip.view.TripFragment;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.view.MainController;
import pl.edu.ug.inf.am.trip.view.LocationSelectFragment;

import javax.inject.Singleton;

@Singleton
@Component(modules = {GameViewModule.class, StagesModule.class})
public interface DiComponent {

    MainController viewManage();
    GameStateManager gameStateManager();

    void inject(LocationSelectFragment locationSelectFragment);
    void inject(GameActivity gameActivity);
    void inject(FightFragment fightFragment);
    void inject(WinFragment winFragment);
    void inject(PlayerReviewFragment playerReviewFragment);
    void inject(TripFragment tripFragment);
    void inject(QuestionFragment questionFragment);
}
