package pl.aml.location;

import pl.aml.impl.location.Place;

public class Area {
    private double longitude;
    private double latitude;
    private double radius;
    private Place place;

    public Area(double longitude, double latitude, double radius, Place place) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.radius = radius;
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }
}
