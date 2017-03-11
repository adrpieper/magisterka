package pl.edu.ug.inf.am.trip.location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.impl.location.Place;
import pl.edu.ug.inf.am.trip.controller.LocationManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-03-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class NFCListenerTest {


    @Mock
    private LocationManager locationManager;
    @InjectMocks
    private NFCListener underTest;

    @Test
    public void enter_whenPlaceExists() {
        underTest.onRead("Castle");
        verify(locationManager).enterInto(Place.CASTLE);
    }

    @Test
    public void doNothing_whenPlaceDontExists() {
        underTest.onRead("SomeTag");
        verifyNoMoreInteractions(locationManager);
    }

}