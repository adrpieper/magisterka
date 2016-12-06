package pl.aml.adventure;

import pl.aml.Location;
import pl.aml.opponent.OpponentType;
import pl.aml.adventure.definition.AdventureDefinition;
import pl.aml.adventure.factory.AdventureInstance;

public class AmlInternalDSL {

    public static QuestionBuilder aQuestion(String question) {
        return new QuestionBuilder(question);
    }

    public static QuestionAnswer aAnswer(String answer, AStage stage) {
        return new QuestionAnswer(answer, stage);
    }

    public static AFight aFightWith(OpponentType... opponnents){
        return new AFightBuilder().with(opponnents).build();
    }

    public static AFightBuilder aFight(){
        return new AFightBuilder();
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

    public static AStage add(Location location, Class<? extends AdventureDefinition> definition) {
        return new AdventureAdder(new AdventureInstance(location, definition, 1));
    }

    public static AStage multi(AStage... stages) {
        return new MultiStages(stages);
    }

    public static End end(){
        return End.instance();
    }
}
