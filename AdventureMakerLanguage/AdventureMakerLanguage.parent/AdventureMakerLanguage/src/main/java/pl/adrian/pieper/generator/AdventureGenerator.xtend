package pl.adrian.pieper.generator


import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Adventure
class AdventureGenerator extends SingleClassGenerator{

    new(String packageName){
        super(
                "AdventuresFactory",
                packageName,
                "public class"
        )

        addImports(
            "java.util.List",
            "java.util.ArrayList",
            "pl.aml.Adventure"
        )
        addStaticImports(
            "pl.aml.MonsterType.*",
            "pl.aml.Location.*"
        )
    }

    override def generateBody(Resource resource){

        var adventures = resource.allContents.filter(typeof(Adventure)).toIterable

        return '''

            public List<Adventure> createAdventures() {
                List<Adventure> result = new ArrayList<>();

                «FOR adventure : adventures»
                    result.add(
                        «adventure.generate»
                    );
                «ENDFOR»
                return result;
            }

        '''

    }

    private def generate(Adventure adventure){
        return '''
        new Adventure (
            «adventure.getLocation.name.toUpperCase»
        )
        '''
    }
}