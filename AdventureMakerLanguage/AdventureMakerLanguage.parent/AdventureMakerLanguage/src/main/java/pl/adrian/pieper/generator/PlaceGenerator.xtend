package pl.adrian.pieper.generator

import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Location
import pl.adrian.pieper.aML.Place
import pl.adrian.pieper.aML.TagLoc
import pl.adrian.pieper.aML.GPSLoc

/**
 * Created by Adi on 2016-09-18.
 */
class PlaceGenerator extends SingleClassGenerator{

    new(String packageName){
        super("Place", packageName, "public enum")
        addImports(AMLGenerator.MAIN_PACKAGE + ".location.*;")
    }

    override def generateBody(Resource resource){

        var locs = resource.allContents.filter(typeof(Location)).toIterable

        return '''
            «FOR loc : locs SEPARATOR ','»
                «loc.name.toUpperCase» («loc.place.generateContent»)
            «ENDFOR»
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
        '''

    }

    private def generateContent(Place place){

        switch place {
            TagLoc : generateTagLoc(place)
            GPSLoc : generateGSPLoc(place)
            default : "ERROR"
        }
    }

    private def generateTagLoc(TagLoc tagLoc){
        return '''"«tagLoc.getTag()»"'''
    }

    private def generateGSPLoc(GPSLoc gpsLoc){
        return ''''''
    }

}