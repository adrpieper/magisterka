package pl.aml.adventure;

import pl.aml.impl.item.ItemType;
import pl.aml.impl.opponent.OpponentType;

import java.util.List;

public interface AdventureEngine {
    void fight(List<OpponentType> opponents, AStage doOnWin, AStage doOnLost);
    void end();
    void addStages(List<AStage> stages);

    void ask(String question, List<QuestionAnswer> answers);

    boolean check(APredicate predicate);

    void addAdventure(AdventureInstance adventureInstance);

    void removeAdventure(AdventureInstance adventureInstance);

    void playerGetItem(List<ItemType> itemType);

    void showMessage(String message);
}
