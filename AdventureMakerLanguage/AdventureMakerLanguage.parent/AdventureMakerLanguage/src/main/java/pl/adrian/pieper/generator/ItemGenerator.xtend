package pl.adrian.pieper.generator


import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Item
import pl.adrian.pieper.generator.builder.ClassBodyBuilder
import static pl.adrian.pieper.generator.builder.Accessor.*;
import static pl.adrian.pieper.generator.builder.BuilderUtils.*;
import static pl.adrian.pieper.generator.AMLGenerator.*;

class ItemGenerator extends SingleClassGenerator{

    new(String packageName){
        super("ItemType", packageName, "public enum")

        addImports (
                MAIN_PACKAGE+".item.*"
        )

        addStaticImports (
                MAIN_PACKAGE+".character.StatType.*",
                MAIN_PACKAGE+".item.Items.*",
                MAIN_PACKAGE+".item.SlotType.*"
        )
    }

    def generateBonuses(Item item){
        return '''«FOR bonus : item.bonuses SEPARATOR ','»plus( «bonus.value», «bonus.type.getName»)«ENDFOR»'''
    }

    override def generateBody(Resource resource){

        var items = resource.allContents.filter(typeof(Item)).toIterable

        return '''
            «FOR item : items SEPARATOR ','»
                «item.name.toUpperCase»(«item.value», «item.slotType.getName», «item.generateBonuses»)
            «ENDFOR»
            ;
            private final int cost;
            private final SlotType slotType;
            private final Bonus[] bonuses;

            ItemType(int cost, SlotType slotType, Bonus... bonuses) {
                this.cost = cost;
                this.slotType = slotType;
                this.bonuses = bonuses;
            }

            public int getCost() {
                return cost;
            }

            public Bonus[] getBonuses() {
                return bonuses;
            }

            public SlotType getSlotType() {
                return slotType;
            }
        '''
    }
}