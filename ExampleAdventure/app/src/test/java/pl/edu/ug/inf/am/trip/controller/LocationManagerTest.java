package pl.edu.ug.inf.am.trip.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.adventure.Adventure;
import pl.aml.impl.location.Place;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;
import pl.edu.ug.inf.am.game.logic.AdventurePicker;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-03-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationManagerTest {
    @Mock
    private AdventurePicker adventurePicker;
    @Mock
    private GameSubComponentManager gameSubComponentManager;
    @InjectMocks
    private LocationManager underTest;

    private final Adventure ADVENTURE = new Adventure(null);

    @Test
    public void enterInto() throws Exception {
        when(adventurePicker.pick(Place.CASTLE)).thenReturn(ADVENTURE);

        underTest.enterInto(Place.CASTLE);

        verify(gameSubComponentManager).startAdventure(ADVENTURE);
    }

}