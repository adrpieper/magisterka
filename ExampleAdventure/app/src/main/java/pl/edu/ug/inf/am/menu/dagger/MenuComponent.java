package pl.edu.ug.inf.am.menu.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.menu.logic.PlayerStateFactory;

@Subcomponent
@PerMenu
public interface MenuComponent {
    PlayerStateFactory playerStateFactory();
}
