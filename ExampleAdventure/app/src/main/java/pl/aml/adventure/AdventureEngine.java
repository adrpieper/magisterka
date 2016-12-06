package pl.aml.adventure;

import pl.aml.opponent.OpponentType;
import pl.aml.adventure.factory.AdventureInstance;

import java.util.List;

public interface AdventureEngine {
    void fight(List<OpponentType> opponents, AStage doOnWin, AStage doOnLost);
    void end();
    void addStages(List<AStage> stages);

    void ask(String question, List<QuestionAnswer> answers);

    boolean check(APredicate predicate);

    void addAdventure(AdventureInstance adventureInstance);
}
