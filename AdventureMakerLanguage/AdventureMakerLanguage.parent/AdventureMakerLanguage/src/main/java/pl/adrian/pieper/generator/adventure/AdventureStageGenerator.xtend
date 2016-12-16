package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.aML.Stage
import pl.adrian.pieper.aML.DecisionStage
import pl.adrian.pieper.aML.TestStage
import pl.adrian.pieper.aML.FightStage

class AdventureStageGenerator {

    AdventureConditionGenerator conditionGenerator = new AdventureConditionGenerator

    def String generate(Stage stage) {
        switch (stage) {
            DecisionStage : return generate(stage)
            TestStage : return generate(stage)
            FightStage : return generate(stage)
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
}