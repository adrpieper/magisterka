package pl.aml.adventure;

import pl.aml.impl.item.ItemType;
import pl.aml.impl.location.Place;
import pl.aml.impl.opponent.OpponentType;

public class AmlInternalDSL {

    public static QuestionBuilder aQuestion(String question) {
        return new QuestionBuilder(question);
    }

    public static QuestionAnswer aAnswer(String answer, AStage stage) {
        return new QuestionAnswer(answer, stage);
    }

    public static AFightBuilder aFightWith(OpponentType... opponnents){
        return new AFightBuilder().with(opponnents);
    }

    public static ConditionBuilder check(APredicate predicate) {
        return new ConditionBuilder().withPredicate(predicate);
    }

    public static AStageBuilder multi(AStageBuilder... aStageBuilders){
        AStage[] stages = new AStage[aStageBuilders.length];
        for (int i = 0; i < aStageBuilders.length; i++) {
            stages[i] = aStageBuilders[i].build();
        }

        return new MultiStages(stages);
    }
    public static AStageBuilder add(Place place, Class<? extends AdventureDefinition> definition,int frequency) {
        return new AdventureAdder(new AdventureInstance(place, definition, frequency));
    }

    public static AStageBuilder add(Place place, Class<? extends AdventureDefinition> definition) {
        return add(place, definition, 1);
    }

    public static AStageBuilder remove(Place place, Class<? extends AdventureDefinition> definition,int frequency) {
        return new AdventureRemover(new AdventureInstance(place, definition, frequency));
    }

    public static AStageBuilder remove(Place place, Class<? extends AdventureDefinition> definition) {
        return remove(place, definition, 1);
    }

    public static AStageBuilder get(ItemType... items) {
        return new GetItem(items);
    }

    public static AStageBuilder show(String message) {
        return new ShowMessage(message);
    }

    public static AStageBuilder end(){
        return End.instance();
    }
}
