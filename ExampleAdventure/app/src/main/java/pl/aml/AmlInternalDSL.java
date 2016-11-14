package pl.aml;

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

    public static End end(){
        return new End();
    }
}
