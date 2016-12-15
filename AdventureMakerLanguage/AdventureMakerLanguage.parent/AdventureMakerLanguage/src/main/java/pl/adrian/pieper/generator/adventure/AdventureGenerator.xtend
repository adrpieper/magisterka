package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.generator.MultiClassGenerator
import pl.adrian.pieper.aML.Adventure
import java.util.List
import org.eclipse.emf.ecore.resource.Resource

class AdventureGenerator extends MultiClassGenerator<Adventure>{

    new(String packageName){
        super(packageName, "public class")
        common.addInterfaces("AdventureDefinition")
        common.addImports("pl.aml.adventure.AStage")
        common.addStaticImports(
                "pl.aml.opponent.OpponentType.*",
                "pl.aml.adventure.AmlInternalDSL.*"
        )

    }

    override def String getName(Adventure adventure){
        adventure.name + 'AdventureDefinition'
    }

    override def String getBody(Adventure adventure){
        '''
        @Override
        public AStage define() {
            return aFightWith();
        }
        '''
    }

    override def Iterable<Adventure> getItems(Resource resource){
        resource.allContents.filter(typeof(Adventure)).toIterable
    }
}