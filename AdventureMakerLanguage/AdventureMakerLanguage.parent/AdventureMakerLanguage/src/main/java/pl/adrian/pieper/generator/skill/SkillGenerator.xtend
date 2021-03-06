package pl.adrian.pieper.generator.skill

import pl.adrian.pieper.generator.SingleClassGenerator
import org.eclipse.emf.ecore.resource.Resource
import pl.adrian.pieper.aML.Skill
import pl.adrian.pieper.aML.DamageFormula
import pl.adrian.pieper.aML.DamageValue
import pl.adrian.pieper.aML.DamageRightSideExpression
import pl.adrian.pieper.aML.DamageVariable
import pl.adrian.pieper.aML.DamageConstant
import pl.adrian.pieper.aML.DamageBrackets
import pl.adrian.pieper.generator.AMLGenerator

class SkillGenerator extends SingleClassGenerator{

    new(String packageName){
        super("SkillType", packageName, "public enum")
        addImports (
                AMLGenerator.MAIN_PACKAGE + ".character.*"
        )
    }

    private def generateCooldown(int i){
        if (i<=0){
            return "1";
        }
        return Integer.toString(i);
    }

    override def generateBody(Resource resource){

        var skills = resource.allContents.filter(typeof(Skill)).toIterable

        '''
            «FOR skill : skills SEPARATOR ','»
                «skill.name.toUpperCase» ( new Damage(){
                    @Override
                    protected int calculateDamage(FightValues fightValues) {
                        return «generate(skill.effect.damageFormula)»;
                    }
                }, «skill.mpCost», «skill.cooldown.generateCooldown»)
            «ENDFOR»
            ;

            private final Effect effect;
            private int mpCost;
            private int cooldown;

            «className» (Effect effect, int mpCost, int cooldown) {
                this.effect = effect;
                this.mpCost = mpCost;
                this.cooldown = cooldown;
            }

            public Effect getEffect() {
                return effect;
            }

            public int getCooldown() {
                return cooldown;
            }

            public int getMpCost() {
                return mpCost;
            }
        '''
    }

    private def generate(DamageFormula formula) {
        return formula.value.generate + generate(formula.expression)
    }

    private def generate(DamageValue v) {
        switch v {
            DamageVariable : v.generate
            DamageConstant : v.generate
            DamageBrackets : v.generate
        }
    }

    private def generate(DamageRightSideExpression expression) {
        if (expression == null) {
            return ""
        }

        return ''' «expression.operation.literal» «generate(expression.right)»'''
    }

    private def generate(DamageVariable damageVariable) {
        return '''fightValues.player«damageVariable.value.literal.toFirstUpper»()'''
    }

    private def generate(DamageConstant damageConstant) {
        return Integer.toString(damageConstant.value)
    }

    private def generate(DamageBrackets brackets) {
        return '''(«brackets.formula.generate»)'''
    }
}