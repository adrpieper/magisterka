package pl.edu.ug.inf.am.trip.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.location.Area;
import pl.aml.location.Place;

import java.util.ArrayList;
import java.util.List;

@Module
public class LocationModule {

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
