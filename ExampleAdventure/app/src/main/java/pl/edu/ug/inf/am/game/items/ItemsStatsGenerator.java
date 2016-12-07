package pl.edu.ug.inf.am.game.items;

import pl.aml.character.Stats;
import pl.aml.items.Bonus;
import pl.aml.items.ItemType;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;
import java.util.Collection;
@PerGame
public class ItemsStatsGenerator {

    @Inject
    public ItemsStatsGenerator() {
    }

    public Stats fromItems(Collection<ItemType> items) {

        int intelligence = 0;
        int strength = 0;
        int agility = 0;

        for (ItemType item : items) {
            for (Bonus bonus : item.getBonuses()) {
                switch (bonus.getStatType()) {
                    case AGILITY:
                        agility += bonus.getAmount();
                        break;
                    case INTELLIGENCE:
                        intelligence += bonus.getAmount();
                        break;
                    case STRENGTH:
                        strength += bonus.getAmount();
                        break;
                }
            }
        }


        return new Stats(intelligence, strength,agility);
    }
}
