package pl.edu.ug.inf.am.app.dagger;

import dagger.Component;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.HasSubComponents;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.dagger.GameDataModule;
import pl.edu.ug.inf.am.menu.dagger.MenuComponent;

@PerApp
@Component
public interface AppComponent extends HasSubComponents{

    ComponentsManager componentsManager();
    GameComponent gameComponent(GameDataModule gameDataModule);
    MenuComponent menuComponent();
    AppSubComponentManager subComponentsManager();

}
