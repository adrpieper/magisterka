package pl.adrian.pieper.generator.start

import pl.adrian.pieper.generator.SingleClassGenerator
import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.StartData
import pl.adrian.pieper.generator.adventure.AdventureInstanceGenerator

class AdventuresOnStartGenerator extends SingleClassGenerator{
    extension final AdventureInstanceGenerator adventureInstanceGenerator = new AdventureInstanceGenerator

    new(String packageName){
        super("AdventuresOnStart", packageName, "public class")
        addImports(
                "pl.aml.adventure.definition.*",
                "pl.aml.adventure.AdventureInstance",
                "java.util.List")
        addStaticImports("pl.aml.location.Place.*")
    }

    override def generateBody(Resource resource){

        var startData = resource.getAllContents.findFirst([object | object instanceof StartData]) as StartData

        return '''
            public void load(List<AdventureInstance> instances) {
                «FOR instance : startData.adventureInstances»
                instances.add(new AdventureInstance(«instance.generate»));
                «ENDFOR»
            }
        '''
    }
}