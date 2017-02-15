package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.impl.character.SkillType;
import pl.edu.ug.inf.am.BR;

public class SkillModel extends BaseObservable {
    private final SkillType skillType;
    private int cooldown;
    private boolean canUse;

    public SkillModel(SkillType skillType) {

        this.skillType = skillType;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public int getMpCost() {
        return skillType.getMpCost();
    }

    public String getName() {
        return skillType.name();
    }

    @Bindable
    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
        notifyPropertyChanged(BR.cooldown);
    }

    public void resetCooldown() {
        setCooldown(skillType.getCooldown());
    }

    @Bindable
    public boolean isCanUse() {
        return canUse;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
        notifyPropertyChanged(BR.canUse);
    }
}
