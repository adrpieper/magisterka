package pl.edu.ug.inf.am.game.items;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.StatType;
import pl.aml.character.Stats;
import pl.aml.impl.item.ItemType;
import pl.aml.item.Bonus;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ItemsStatsGeneratorTest {
    @InjectMocks
    private ItemsStatsGenerator underTest;

    @Test
    public void fromItems() throws Exception {
        Stats stats = underTest.fromItems(Arrays.asList(ItemType.values()));

        int strengthBonus = 0;
        for (ItemType itemType : ItemType.values()) {
            for (Bonus bonus : itemType.getBonuses()) {
                if (bonus.getStatType() == StatType.STRENGTH) {
                    strengthBonus += bonus.getAmount();
                }
            }
        }

        Assertions.assertThat(stats.getStrength()).isEqualTo(strengthBonus);
    }
}