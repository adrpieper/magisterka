package pl.edu.ug.inf.am.trip.skills;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.collections.Sets;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.SkillNode;
import pl.aml.impl.character.SkillType;
import pl.edu.ug.inf.am.trip.skills.model.SkillsModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-03-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillsControllerTest {
    @Mock
    private SkillsModel skillsModel;
    @InjectMocks
    private SkillsController underTest;
    @Mock
    private SkillNode skill = new SkillNode(SkillType.BASIC_HIT);

    @Test
    public void canUnlock_whenHasNoParentAndHasSkillsPoints() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(1);
        when(skill.getParent()).thenReturn(null);

        assertThat(underTest.canUnlock(skill)).isEqualTo(true);
    }

    @Test
    public void cantUnlock_whenHasNoParentAndHasNoSkillsPoints() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(0);
        when(skill.getParent()).thenReturn(null);

        assertThat(underTest.canUnlock(skill)).isEqualTo(false);
    }

    @Test
    public void canUnlock_whenHasUnlockedParentAndHasSkillsPoints() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(1);
        when(skill.getParent()).thenReturn(SkillType.POISON_HIT);
        when(skillsModel.getSkills()).thenReturn(Sets.newSet(SkillType.POISON_HIT));

        assertThat(underTest.canUnlock(skill)).isEqualTo(true);
    }

    @Test
    public void cantUnlock_whenHasLockedParentAndHasSkillsPoints() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(1);
        when(skill.getParent()).thenReturn(SkillType.POISON_HIT);
        when(skillsModel.getSkills()).thenReturn(java.util.Collections.<SkillType>emptySet());

        assertThat(underTest.canUnlock(skill)).isEqualTo(false);
    }

    @Test
    public void unlockSkill_whenCanUnlock() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(1);
        when(skill.getParent()).thenReturn(null);
        when(skill.getSkillType()).thenReturn(SkillType.BASIC_HIT);

        underTest.unlockSkill(skill);

        verify(skillsModel).removeSkillPoint();
        verify(skillsModel).addSkill(skill.getSkillType());
    }

    @Test
    public void dontUnlockSkill_whenCantUnlock() throws Exception {
        when(skillsModel.getSkillsPoints()).thenReturn(0);

        underTest.unlockSkill(skill);

        verify(skillsModel).getSkillsPoints();
        verifyNoMoreInteractions(skillsModel);
    }


    @Test
    public void reset() throws Exception {
        underTest.reset();

        verify(skillsModel).reset();
    }

    @Test
    public void accept() throws Exception {
        underTest.accept();

        verify(skillsModel).accept();
    }

}