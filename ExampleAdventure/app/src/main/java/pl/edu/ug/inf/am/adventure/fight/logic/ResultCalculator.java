package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.impl.item.ItemType;
import pl.aml.opponent.ItemLoot;
import pl.aml.impl.opponent.OpponentType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;
import pl.edu.ug.inf.am.adventure.fight.state.Result;
import pl.edu.ug.inf.am.adventure.fight.state.ResultDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@PerAdventureStage
public class ResultCalculator {

    private final FightModel fightModel;
    private final Random random;

    @Inject
    public ResultCalculator(FightModel fightModel, Random random) {
        this.fightModel = fightModel;
        this.random = random;
    }

    public ResultDTO calculateResult() {
        if (fightModel.getFightStatus() == FightStatus.WIN) {
            return calulateForWin();
        }
        else {
            return calulateForLost();
        }

    }

    private ResultDTO calulateForLost() {
        return new ResultDTO(Result.LOST, 0, Collections.<ItemType>emptyList());
    }

    private ResultDTO calulateForWin() {

        int exp = 0;
        List<ItemType> items = new ArrayList<>();
        for (OpponentType opponentType : fightModel.getKilledMonsters()) {
            exp += opponentType.getExp();
            for (ItemLoot itemLoot : opponentType.getLoots()) {
                if (random.nextInt(100) < itemLoot.getChance()) {
                    items.add(itemLoot.getItemType());
                }
            }
        }

        return new ResultDTO(Result.WIN, exp, items);
    }
}
