package pl.aml;

import java.util.List;

public interface AdventureEngine {
    void fight(List<MonsterType> opponents, AStage doOnWin, AStage doOnLost);
    void end();
    void addStages(List<AStage> stages);

    void ask(String question, List<QuestionAnswer> answers);

    boolean check(APredicate predicate);
}
