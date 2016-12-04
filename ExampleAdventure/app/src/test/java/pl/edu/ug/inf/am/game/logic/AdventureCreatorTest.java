package pl.edu.ug.inf.am.game.logic;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.adventure.AStage;
import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureBuilder;
import pl.aml.adventure.definition.AdventureDefinition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        public void define(AdventureBuilder adventure) {
            adventure.startsFrom(firstStage);
        }
    }

}