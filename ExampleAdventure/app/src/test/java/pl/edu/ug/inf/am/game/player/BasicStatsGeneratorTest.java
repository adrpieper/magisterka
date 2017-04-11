package pl.edu.ug.inf.am.game.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.CharacterType;
import pl.aml.character.Stats;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.aml.character.CharacterDSL.characterClass;

/**
 * Created by Adi on 2017-04-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class BasicStatsGeneratorTest {

    private BasicStatsGenerator underTest = new BasicStatsGenerator();

    private CharacterType characterType = characterClass("Knight")
            .statsOnStart(10, 20, 30)
            .statsPerLevel(1, 2, 3)
            .createCharacterType();
    @Test
    public void generateForLevel0() throws Exception {

        Stats stats = underTest.generate(0, characterType);

        assertThat(stats).isEqualsToByComparingFields(new Stats(10,20,30));
    }

    @Test
    public void generateForLevel2() throws Exception {

        Stats stats = underTest.generate(2, characterType);

        assertThat(stats).isEqualsToByComparingFields(new Stats(12,24,36));
    }

}