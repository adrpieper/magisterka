package pl.aml.character;

import android.support.annotation.NonNull;
import pl.aml.impl.character.SkillType;

public class CharacterDSL {

    public static CharacterTypeBuilder characterClass(String name){
        return new CharacterTypeBuilder().name(name);
    }

    @NonNull
    public static Stats stats(int intelligence, int strength, int agility) {
        return new Stats(strength, intelligence, agility);
    }

    public static SkillNode node(SkillType skill, SkillNode... nodes) {
        for (SkillNode node : nodes) {
            node.setParent(skill);
        }
        return new SkillNode(skill, nodes);
    }
}
