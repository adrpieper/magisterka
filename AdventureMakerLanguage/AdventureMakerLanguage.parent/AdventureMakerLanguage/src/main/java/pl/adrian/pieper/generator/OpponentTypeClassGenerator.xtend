package pl.adrian.pieper.generator

import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Location
import pl.adrian.pieper.aML.Place
import pl.adrian.pieper.aML.TagLoc
import pl.adrian.pieper.aML.GPSLoc
import pl.adrian.pieper.aML.Monster
import pl.adrian.pieper.generator.builder.ClassBodyBuilder
import static pl.adrian.pieper.generator.builder.BuilderUtils.*;
import pl.adrian.pieper.generator.builder.Field
import pl.adrian.pieper.generator.builder.Accessor

class OpponentTypeClassGenerator extends SingleClassGenerator{

    new(String packageName){
        super("OpponentType", packageName, "public enum")
    }

    override def generateBody(Resource resource){

        var monsters = resource.allContents.filter(typeof(Monster)).toIterable

        val builder = new ClassBodyBuilder(className);

        monsters.forEach([monster |
            builder.withEnumInstance(
                monster.name.toUpperCase,
                monster.stats.hp.toString,
                monster.stats.power.toString,
                monster.stats.exp.toString
            )
        ])

        val hpField = new Field("int", "hp", Accessor.GETTER)
        val powerField = new Field("int", "power", Accessor.GETTER)
        val expField = new Field("int", "exp", Accessor.GETTER)

        builder
        .withConstructor(hpField, powerField, expField)
        .withField(hpField)
        .withField(powerField)
        .withField(expField)

        return builder.build
    }
}