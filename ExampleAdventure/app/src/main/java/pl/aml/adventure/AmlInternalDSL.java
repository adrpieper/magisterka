package pl.aml.adventure;

import pl.aml.MonsterType;

public class AmlInternalDSL {

    public static AdventureBuilder aNewAdventure() {
        return new AdventureBuilder();
    }

    public static QuestionBuilder aQuestion(String question) {
        return new QuestionBuilder(question);
    }

    public static QuestionAnswer aAnswer(String answer, AStage stage) {
        return new QuestionAnswer(answer, stage);
    }

    public static AFight aFightWith(MonsterType... opponnents){
        return new AFight(opponnents);
    }

    public static ConditionBuilder check(APredicate predicate) {
        return new ConditionBuilder().withPredicate(predicate);
    }

    public static AStage multi(AStageBuilder... aStageBuilders){
        AStage[] stages = new AStage[aStageBuilders.length];
        for (int i = 0; i < aStageBuilders.length; i++) {
            stages[i] = aStageBuilders[i].build();
        }

        return multi(stages);
    }

    public static AStage multi(AStage... stages) {
        return new MultiStages(stages);
    }

    public static End end(){
        return End.instance();
    }
}
