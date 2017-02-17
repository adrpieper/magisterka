package pl.aml.character;

import pl.aml.impl.character.CharacterTypeDefinitions;
import pl.edu.ug.inf.am.app.dagger.PerApp;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PerApp
public class CharacterTypesProvider {

    private CharacterTypeDefinitions definitions = new CharacterTypeDefinitions();

    @Inject
    public CharacterTypesProvider() {
    }

    public List<CharacterType> provideAll() {
        List<CharacterType> characterTypes = new ArrayList<>();
        for (CharacterTypeBuilder builder : definitions.create()) {
            characterTypes.add(builder.createCharacterType());
        }
        return characterTypes;
    }

}
