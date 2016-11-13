package pl.aml;

import java.util.Collection;
import java.util.List;

public interface AdventureEngine {
    void fight(List<MonsterType> opponents);
    void end();
    void addStages(List<AStage> stages);

    void ask(String question, List<QuestionAnswer> answers);
}
