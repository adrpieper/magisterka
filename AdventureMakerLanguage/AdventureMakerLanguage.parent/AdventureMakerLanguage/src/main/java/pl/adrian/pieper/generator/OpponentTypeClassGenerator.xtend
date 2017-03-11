package pl.adrian.pieper.generator

import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Location
import pl.adrian.pieper.aML.Place
import pl.adrian.pieper.aML.TagLoc
import pl.adrian.pieper.aML.GPSLoc
import pl.adrian.pieper.aML.Opponent
import pl.adrian.pieper.generator.builder.ClassBodyBuilder
import static pl.adrian.pieper.generator.builder.BuilderUtils.*;
import pl.adrian.pieper.generator.builder.Field
import pl.adrian.pieper.generator.builder.Accessor
import pl.adrian.pieper.aML.Stats
import pl.adrian.pieper.aML.Loot

class OpponentTypeClassGenerator extends SingleClassGenerator{

    new(String packageName){
        super("OpponentType", packageName, "public enum")

        addImports (
                AMLGenerator.MAIN_PACKAGE + ".opponent.*"
        )

        addStaticImports (
                AMLGenerator.MAIN_PACKAGE + ".opponent.Opponents.*",
                AMLGenerator.IMPL_PACKAGE + ".item.ItemType.*"
        )
    }

    def generate(Stats stats) {
        return '''«stats.hp»,«stats.power»,«stats.exp»'''
    }

    def generate(Loot loot) {
        return '''
        «FOR item : loot.items», loot(«item.type.name.toUpperCase», «item.chance»)«ENDFOR»
        '''
    }


    override def generateBody(Resource resource){

        var opponents = resource.allContents.filter(typeof(Opponent)).toIterable


        return '''
        «FOR opponent : opponents SEPARATOR ','»
        «opponent.name.toUpperCase» («opponent.stats.generate»«opponent.loot.generate»)
        «ENDFOR»

        ;

        private final int hp;
        private final int power;
        private final int exp;
        private final ItemLoot[] loots;

        OpponentType(int hp, int power, int exp, ItemLoot... loots)  {
            this.hp = hp;
            this.power = power;
            this.exp = exp;
            this.loots = loots;
        }

        public int getHp() {
            return hp;
        }
        public int getPower() {
            return power;
        }
        public int getExp() {
            return exp;
        }
        public ItemLoot[] getLoots() {
            return loots;
        }

        '''
    }
}