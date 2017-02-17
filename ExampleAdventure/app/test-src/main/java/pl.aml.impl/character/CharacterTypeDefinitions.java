package pl.aml.impl.character;

import pl.aml.character.*;

import static pl.aml.character.CharacterDSL.*;
import static pl.aml.impl.character.SkillType.*;

public class CharacterTypeDefinitions {

    public CharacterTypeBuilder[] create() {
        return new CharacterTypeBuilder[]{
                characterClass("Knight")
                        .statsOnStart(10, 20, 30)
                        .statsPerLevel(1, 2, 3)
                        .skills(
                        node(
                                BASIC_HIT,
                                node(POISON_HIT),
                                node(SUPER_POISON_HIT)
                        ),
                        node(POISON_HIT)
                )
        };
    }
}
