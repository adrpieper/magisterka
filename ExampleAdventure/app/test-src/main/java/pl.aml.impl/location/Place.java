package pl.aml.impl.location;

import pl.aml.location.*;

public enum Place {
    FORREST("Forrest")
    ,CASTLE(18.269119, 54.600414, 1000)
    ;

    private final Object loc;

    Place(String tag){
        this.loc = new Tag(tag);
    }

    Place(double longitude, double latitude, double distance) {
        this.loc = new Area(longitude,latitude,distance, this);
    }

    public Tag getTag() {
        if (loc instanceof Tag) {
            return (Tag) loc;
        }
        return null;
    }

    public Area getArea() {
        if (loc instanceof Area) {
            return (Area) loc;
        }
        return null;
    }


}
