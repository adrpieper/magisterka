package pl.edu.ug.inf.am.menu.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.menu.logic.NewGameCreator;
import pl.edu.ug.inf.am.menu.logic.PlayerStateFactory;
import pl.edu.ug.inf.am.menu.view.SelectCharacterActivity;

@PerMenu
@Subcomponent(modules = OnStartModule.class)
public interface MenuComponent {
    NewGameCreator newGameCreator();

    void inject(SelectCharacterActivity selectCharacterActivity);
}
