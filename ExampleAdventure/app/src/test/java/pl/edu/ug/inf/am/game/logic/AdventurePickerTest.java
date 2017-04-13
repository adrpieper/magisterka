package pl.edu.ug.inf.am.game.logic;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureInstance;
import pl.aml.impl.adventure.ExampleDragon;
import pl.aml.impl.location.Place;
import pl.edu.ug.inf.am.common.ObjectRandom;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;

import java.util.Arrays;
import java.util.Random;

import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-04-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdventurePickerTest {
    @Mock
    private AvailableAdventures availableAdventures;

    private ObjectRandom objectRandom = new ObjectRandom(new Random(0));
    @Mock
    private AdventureCreator adventureCreator;
    private AdventurePicker underTest;

    @Mock
    private Adventure adventure;

    @Test
    public void pick() throws Exception {
        underTest = new AdventurePicker(availableAdventures, objectRandom, adventureCreator);

        AdventureInstance adventureInstance = new AdventureInstance(Place.CASTLE, ExampleDragon.class);
        when(availableAdventures.getAdventures(Place.CASTLE)).thenReturn(Arrays.asList(adventureInstance));
        when(adventureCreator.create(adventureInstance.getDefinition())).thenReturn(adventure);

        Adventure pick = underTest.pick(Place.CASTLE);
        Assertions.assertThat(pick).isEqualsToByComparingFields(adventure);
    }

}