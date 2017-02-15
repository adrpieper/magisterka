package pl.edu.ug.inf.am.menu.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.menu.logic.NewGameCreator;
import pl.edu.ug.inf.am.menu.logic.PlayerStateFactory;

@PerMenu
@Subcomponent(modules = OnStartModule.class)
public interface MenuComponent {
    NewGameCreator newGameCreator();
}
