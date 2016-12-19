package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.aML.Stage
import pl.adrian.pieper.aML.DecisionStage
import pl.adrian.pieper.aML.TestStage
import pl.adrian.pieper.aML.FightStage
import pl.adrian.pieper.aML.AddAdventureInstanceStage
import pl.adrian.pieper.aML.AdventureInstance
import pl.adrian.pieper.aML.RemoveAdventureInstanceStage
import pl.adrian.pieper.aML.MultiStage
import pl.adrian.pieper.aML.ShowTextStage
import pl.adrian.pieper.aML.GetItemStage

class AdventureStageGenerator {

    AdventureConditionGenerator conditionGenerator = new AdventureConditionGenerator
    extension final AdventureClassNameGenerator adventureClassNameGenerator = new AdventureClassNameGenerator

    def String generate(Stage stage) {
        switch (stage) {
            DecisionStage : return generate(stage)
            TestStage : return generate(stage)
            FightStage : return generate(stage)
            AddAdventureInstanceStage : return generate(stage)
            RemoveAdventureInstanceStage : return generate(stage)
            MultiStage : return generate(stage)
            ShowTextStage : return generate(stage)
            GetItemStage : return generate(stage)
        }
    }

    def String generate(DecisionStage decision) {
        return
        '''
        aQuestion("«decision.question»")
            «FOR answer : decision.answers»
                .withAnswer("«answer.answer»", «generate(answer.stage)»)
            «ENDFOR»
        '''
    }

    def String generate(TestStage test) {
        return '''
        check(new APredicate() {
            @Override
            public boolean isTrue(AContext c) {
                    return «conditionGenerator.generate(test.contition)»;
            }
        })
        .ifTrue(«generate(test.pos)»)
        «IF (test.neg!= null)»
        .ifFalse(«generate(test.neg)»)«ENDIF»
        '''
    }

    def String generate(FightStage fight) {
        return '''
        aFightWith( «FOR opponent : fight.oponents SEPARATOR ','» «opponent.name.toUpperCase» «ENDFOR»)
        «IF (fight.onWin!= null)»
            .onWin(«generate(fight.onWin)»)«ENDIF»
        «IF (fight.onLost!= null)»
            .onLost(«generate(fight.onLost)»)«ENDIF»
        '''
    }
    def String generate(AdventureInstance instance) {
        return instance.adventure.generateClassName + ".class"+ generateFreqency(instance.freqency)
    }

    def String generateFreqency(int freq) {
        if (freq == 0) {
            return ""
        }
        return "," + freq;
    }

    def String generate(AddAdventureInstanceStage stage) {
        return '''add(«generate(stage.instance)»)'''
    }

    def String generate(RemoveAdventureInstanceStage stage) {
        return '''remove(«generate(stage.instance)»)'''
    }

    def String generate(MultiStage multiStage) {
        return '''multi(
            «FOR stage : multiStage.stages SEPARATOR ','»
            «generate(stage)»
            «ENDFOR»
        )'''
    }

    def String generate(ShowTextStage showText) {
        return '''show("«showText.text»")'''
    }

    def String generate(GetItemStage getItem) {
        return '''get(«getItem.item.name.toUpperCase»)'''
    }
}