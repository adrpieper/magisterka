package pl.edu.ug.inf.am.trip.location;

import pl.aml.impl.location.Place;
import pl.aml.location.Tag;
import pl.edu.ug.inf.am.nfc.NFC;
import pl.edu.ug.inf.am.trip.controller.LocationManager;
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
        Place place = forTag(tagMessage);
        if (place != null) {
            locationManager.enterInto(place);
        }
    }

    public static Place forTag(String tag){
        Tag placeTag = new Tag(tag);
        for (Place place : Place.values()){
            if (placeTag.equals(place)){
                return place;
            }
        }
        return null;
    }
}
