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
    }

    override def generateBody(Resource resource){

        var locs = resource.allContents.filter(typeof(Location)).toIterable

        return '''
            «FOR loc : locs SEPARATOR ','»
                «loc.name.toUpperCase» («loc.place.generateContent»)
            «ENDFOR»
            ;

            private Tag tag;

            private «className»(Tag tag) {
                this.tag = tag;
            }

            private static class Tag {
                String tagCode;

                Tag(String tagCode) {
                    this.tagCode = tagCode;
                }
            }

            private static Tag tag(String tagCode){
                return new Tag(tagCode);
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
        return '''tag("«tagLoc.getTag()»")'''
    }

    private def generateGSPLoc(GPSLoc gpsLoc){
        return "TODO"
    }

}