package pl.aml.impl.location;

import pl.aml.location.Area;

public enum Place {
    FORREST()
    ,CASTLE(18.269119, 54.600414, 1000)
    ;

    private final Area area;

    Place(){
        this.area = null;
    }

    Place(double longitude, double latitude, double distance) {
        this.area = new Area(longitude,latitude,distance, this);
    }

    public Area getArea() {
        return area;
    }

    public static Place forTag(String tag){
        for (Place place : values()) {
            if (place.name().equals(tag)){
                return place;
            }
        }
        return null;
    }

}
