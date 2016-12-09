package pl.aml.location;

public enum Location {
    FORREST()
    ,CASTLE
    ;

    public static Location forTag(String tag){
        for (Location location : values()) {
            if (location.name().equals(tag)){
                return location;
            }
        }
        return null;
    }
}
