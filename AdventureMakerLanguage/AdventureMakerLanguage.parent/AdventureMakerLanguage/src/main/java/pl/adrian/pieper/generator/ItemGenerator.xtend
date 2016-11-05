package pl.adrian.pieper.generator


import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Item
import pl.adrian.pieper.generator.builder.ClassBodyBuilder
import static pl.adrian.pieper.generator.builder.Accessor.*;
import static pl.adrian.pieper.generator.builder.BuilderUtils.*;

class ItemGenerator extends SingleClassGenerator{

    new(String packageName){
        super("ItemType", packageName, "public enum")
    }

    override def generateBody(Resource resource){

        var items = resource.allContents.filter(typeof(Item)).toIterable

        val builder = new ClassBodyBuilder(className)
        items.forEach([item | builder.withEnumInstance(
                    item.name,
                    item.value.toString
            )])

        builder.withField("int", "value", GETTER)
        builder.withConstructor(aParam("int", "value"))

        return builder.build
    }
}