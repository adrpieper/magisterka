package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.character.SkillType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.SkillModel;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@PerAdventureStage
public class SkillsLogic {

    private final FightModel fight;
    private final AdventurePlayerModel playerModel;
    private final FightEngineImpl fightEngine;

    @Inject
    public SkillsLogic(FightModel fight, AdventurePlayerModel playerModel, FightEngineImpl fightEngine) {
        this.fight = fight;
        this.playerModel = playerModel;
        this.fightEngine = fightEngine;
    }

    public void createSkillsList() {
        Set<SkillType> skillsTypes = playerModel.getSkills();
        List<SkillModel> skills = new ArrayList<>();
        for (SkillType skillsType : skillsTypes) {
            skills.add(new SkillModel(skillsType));
        }
        fight.setSkillsModels(skills);
        checkSkills();
    }

    public void checkSkills() {
        for (SkillModel skillModel : fight.getSkillsModels()) {
            skillModel.setCanUse(canUse(skillModel));
        }
    }

    public void playerUse(SkillModel skill) {
        if (canUse(skill)) {
            SkillType skillType = skill.getSkillType();
            fight.setPlayerMp(fight.getPlayerMp() - skillType.getMpCost());
            skill.resetCooldown();
            skillType.getEffect().use(fightEngine);
            for (SkillModel skillModel : fight.getSkillsModels()) {
                skillModel.setCanUse(canUse(skillModel));
            }
        }
    }

    public void degreaseCooldowns() {
        for (SkillModel skillModel : fight.getSkillsModels()) {
            int cooldown = skillModel.getCooldown();
            if (cooldown > 0){
                skillModel.setCooldown(cooldown - 1);
            }
        }
        checkSkills();
    }

    private boolean canUse(SkillModel skillModel) {
        return (skillModel.getCooldown() == 0) && (skillModel.getMpCost() <= fight.getPlayerMp());
    }
}
