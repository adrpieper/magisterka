package pl.edu.ug.inf.am.trip.location;

import android.location.Location;
import pl.aml.location.Area;
import pl.aml.location.Place;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;

import javax.inject.Inject;
import java.util.List;

@PerTrip
public class PlaceProvider {

    private final List<Area> areas;

    @Inject
    public PlaceProvider(List<Area> areas) {
        this.areas = areas;
    }

    public Place forCoOrdinates(Location location) {
        Location areaLocation = new Location("");

        for (Area area : areas) {
            areaLocation.setLatitude(area.getLatitude());
            areaLocation.setLongitude(area.getLongitude());
            if (location.distanceTo(areaLocation) <= area.getRadius()) {
                return area.getPlace();
            }
        }

        return null;
    }
}
