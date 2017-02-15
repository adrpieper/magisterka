package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.generator.MultiClassGenerator
import pl.adrian.pieper.aML.Adventure
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.generator.AMLGenerator

class AdventureGenerator extends MultiClassGenerator<Adventure>{

    extension final AdventureStageGenerator stageGenerator = new AdventureStageGenerator;
    extension final AdventureClassNameGenerator adventureNameGenerator = new AdventureClassNameGenerator

    new(String packageName){
        super(packageName, "public class")
        common.addInterfaces("AdventureDefinition")
        common.addImports(AMLGenerator.MAIN_PACKAGE + ".adventure.*")
        common.addStaticImports(
                AMLGenerator.IMPL_PACKAGE+".location.Place.*",
                AMLGenerator.IMPL_PACKAGE+".item.ItemType.*",
                AMLGenerator.IMPL_PACKAGE+".opponent.OpponentType.*",
                AMLGenerator.MAIN_PACKAGE+".adventure.AmlInternalDSL.*"
        )

    }

    override def String getName(Adventure adventure){
        adventure.generateClassName
    }

    override def String getBody(Adventure adventure){
        '''
        @Override
        public AStage define() {
            return «adventure.startStage.generate».build();
        }
        '''
    }

    override def Iterable<Adventure> getItems(Resource resource){
        resource.allContents.filter(typeof(Adventure)).toIterable
    }
}