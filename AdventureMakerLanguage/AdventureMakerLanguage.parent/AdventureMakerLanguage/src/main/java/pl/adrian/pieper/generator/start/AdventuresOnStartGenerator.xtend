package pl.adrian.pieper.generator.start

import pl.adrian.pieper.generator.SingleClassGenerator
import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.StartData
import pl.adrian.pieper.generator.adventure.AdventureInstanceGenerator
import pl.adrian.pieper.generator.AMLGenerator

class AdventuresOnStartGenerator extends SingleClassGenerator{
    extension final AdventureInstanceGenerator adventureInstanceGenerator = new AdventureInstanceGenerator

    new(String packageName){
        super("AdventuresOnStart", packageName, "public class")
        addImports(
                AMLGenerator.IMPL_PACKAGE + ".adventure.*",
                AMLGenerator.MAIN_PACKAGE + ".adventure.*",
                "java.util.List")
        addStaticImports(AMLGenerator.IMPL_PACKAGE+".location.Place.*")
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