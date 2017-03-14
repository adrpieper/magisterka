package pl.edu.ug.inf.am.trip.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.ug.inf.am.gps.GPS;
import pl.edu.ug.inf.am.nfc.NFC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-03-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TripListenersManagerTest {
    @Mock
    private GPS gps;
    @Mock
    private GPS.GPSListener gpsListener;
    @Mock
    private NFC nfc;
    @Mock
    private NFC.TagReaderListener tagReaderListener;
    @InjectMocks
    private TripListenersManager underTest;

    @Test
    public void register() throws Exception {
        underTest.register();
        verify(nfc).setListener(tagReaderListener);
        verify(gps).setListener(gpsListener);
    }

    @Test
    public void unregister() throws Exception {
        underTest.unregister();
        verify(nfc).setListener(null);
        verify(gps).setListener(null);
    }

}