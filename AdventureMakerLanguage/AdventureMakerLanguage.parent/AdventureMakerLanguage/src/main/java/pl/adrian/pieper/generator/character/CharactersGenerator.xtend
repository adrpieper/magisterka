package pl.adrian.pieper.generator.character

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
import pl.adrian.pieper.aML.Stats
import pl.adrian.pieper.aML.Loot
import pl.adrian.pieper.aML.CharacterType
import pl.adrian.pieper.generator.SingleClassGenerator
import pl.adrian.pieper.generator.AMLGenerator
import pl.adrian.pieper.aML.SkillsNode

class CharactersGenerator extends SingleClassGenerator{

    new(String packageName){
        super("CharacterTypeDefinitions", packageName, "public class")

        addImports (
                AMLGenerator.MAIN_PACKAGE + ".character.*"
        )

        addStaticImports (
                AMLGenerator.MAIN_PACKAGE + ".character.CharacterDSL.*",
                AMLGenerator.IMPL_PACKAGE + ".character.SkillType.*"
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

    def generateCode(SkillsNode node) {
        return '''
            node(
                «node.skill.getName.toUpperCase»
                «FOR child : node.childs»,
                «child.generateCode»
                «ENDFOR»
            )
        '''
    }

    def generateCode(CharacterType c) {
        return '''
            characterClass("«c.getName»")
                .statsOnStart(«c.getStr», «c.getInt», «c.getAgi»)
                .statsPerLevel(«c.getStrPerLevel», «c.getIntPerLevel», «c.getAgiPerLevel»)
                .skills(
                «FOR node : c.skillsTrees SEPARATOR ','»
                «node.generateCode»
                «ENDFOR»
                )
        '''
    }

    override def generateBody(Resource resource){

        var characters = resource.allContents.filter(typeof(CharacterType)).toIterable

        return '''
        public CharacterTypeBuilder[] create() {
            return new CharacterTypeBuilder[]{
                «FOR character : characters SEPARATOR ','»
                «character.generateCode»
                «ENDFOR»
            };
        }
        '''
    }
}