package pl.edu.ug.inf.am.trip.controller;

import pl.edu.ug.inf.am.gps.GPS;
import pl.edu.ug.inf.am.nfc.NFC;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.trip.location.GPSListenerImpl;
import pl.edu.ug.inf.am.trip.location.NFCListener;

import javax.inject.Inject;

@PerTrip
public class TripManager {

    private final GPS gps;
    private final GPS.GPSListener gpsListener;
    private final NFC nfc;
    private final NFC.TagReaderListener nfcListener;

    @Inject
    public TripManager(GPS gps, GPSListenerImpl gpsListener, NFC nfc, NFCListener nfcListener) {
        this.gps = gps;
        this.gpsListener = gpsListener;
        this.nfc = nfc;
        this.nfcListener = nfcListener;
    }

    public void startTrip() {
        gps.setListener(gpsListener);
        nfc.setListener(nfcListener);
    }

    public void endTrip() {
        gps.setListener(null);
        nfc.setListener(null);
    }
}
