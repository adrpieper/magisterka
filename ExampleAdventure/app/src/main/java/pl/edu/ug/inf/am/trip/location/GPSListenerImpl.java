package pl.edu.ug.inf.am.trip.location;

import android.location.Location;
import pl.aml.location.Place;
import pl.edu.ug.inf.am.gps.GPS;
import pl.edu.ug.inf.am.trip.controller.LocationManager;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;

import javax.inject.Inject;

@PerTrip
public class GPSListenerImpl implements GPS.GPSListener{

    private PlaceProvider provider;
    private LocationManager locationManager;

    @Inject
    public GPSListenerImpl(PlaceProvider provider, LocationManager locationManager) {
        this.provider = provider;
        this.locationManager = locationManager;
    }

    @Override
    public void onLocationChanged(Location location) {
        Place place = provider.forCoOrdinates(location);
        if (place != null) {
            locationManager.enterInto(place);
        }
    }
}
