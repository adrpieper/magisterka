package pl.aml.impl.character;

import pl.aml.character.*;
import pl.aml.impl.character.SkillType;

public class ExampleCharacterTypeFactory implements CharacterTypeFactory {

    @Override
    public CharacterType create() {

        Stats statsOnStart = new Stats(10,20,30);
        Stats statsPerStart = new Stats(1,2,3);

        SkillNode mainNode = new SkillNode(SkillType.BASIC_HIT,
                new SkillNode(SkillType.POISON_HIT, SkillType.BASIC_HIT),
                new SkillNode(SkillType.SUPER_POISON_HIT, SkillType.BASIC_HIT));
        SkillNode secondNode = new SkillNode(SkillType.POISON_HIT);
        SkillTree skillTree = new SkillTree(mainNode,secondNode);
        return new CharacterType(statsOnStart, statsPerStart, skillTree);
    }
}
