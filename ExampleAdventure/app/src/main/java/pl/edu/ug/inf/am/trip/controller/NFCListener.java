package pl.edu.ug.inf.am.trip.controller;

import pl.aml.location.Location;
import pl.edu.ug.inf.am.nfc.NFC;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;

import javax.inject.Inject;

@PerTrip
public class NFCListener implements NFC.TagReaderListener {

    private LocationManager locationManager;

    @Inject
    public NFCListener(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    @Override
    public void onRead(String tagMessage) {
        Location location = Location.forTag(tagMessage);
        if (location != null) {
            locationManager.enterInto(location);
        }
    }
}
