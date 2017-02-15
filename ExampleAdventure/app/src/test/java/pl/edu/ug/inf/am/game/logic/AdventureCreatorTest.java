package pl.edu.ug.inf.am.game.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.adventure.AStage;
import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureDefinition;

/**
 * Created by Adi on 2016-12-03.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdventureCreatorTest {

    @Mock
    private static AStage firstStage;

    @InjectMocks
    private AdventureCreator underTest;

    @Test
    public void create() throws Exception {

        Adventure adventure = underTest.create(MockAdventure.class);
        assert  adventure.getFirstStage() == firstStage;
    }

    public static class MockAdventure implements AdventureDefinition {

        @Override
        public AStage define() {
            return firstStage;
        }
    }

}