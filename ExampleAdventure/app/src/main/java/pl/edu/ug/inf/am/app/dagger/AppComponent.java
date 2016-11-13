package pl.edu.ug.inf.am.app.dagger;

import dagger.Component;
import pl.edu.ug.inf.am.app.stage.AppStagesManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;

@PerApp
@Component
public interface AppComponent {


    AppStagesManager appStagesManager();

    GameComponent gameComponent();
}
