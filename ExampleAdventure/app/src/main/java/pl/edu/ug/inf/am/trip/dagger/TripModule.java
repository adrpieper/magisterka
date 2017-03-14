package pl.edu.ug.inf.am.trip.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.location.Area;
import pl.aml.impl.location.Place;
import pl.edu.ug.inf.am.gps.GPS;
import pl.edu.ug.inf.am.nfc.NFC;
import pl.edu.ug.inf.am.trip.controller.TripListenersManager;
import pl.edu.ug.inf.am.trip.location.GPSListenerImpl;
import pl.edu.ug.inf.am.trip.location.NFCListener;

import java.util.ArrayList;
import java.util.List;

@Module
public class TripModule {

    @PerTrip
    @Provides
    public TripListenersManager provideTripListenersManager(GPS gps, GPSListenerImpl gpsListener, NFC nfc, NFCListener nfcListener) {
        return new TripListenersManager(gps,gpsListener,nfc,nfcListener);
    }

    @PerTrip
    @Provides
    public List<Area> provideAreas() {

        List<Area> result = new ArrayList<>();

        for (Place place : Place.values()) {
            if (place.getArea() != null) {
                result.add(place.getArea());
            }
        }

        return result;
    }
}
