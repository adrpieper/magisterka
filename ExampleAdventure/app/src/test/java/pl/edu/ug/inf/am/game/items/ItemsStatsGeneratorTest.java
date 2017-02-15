package pl.edu.ug.inf.am.game.items;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.Stats;
import pl.aml.impl.item.ItemType;

import java.util.Arrays;

/**
 * Created by Adi on 2016-12-06.
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemsStatsGeneratorTest {
    @InjectMocks
    private ItemsStatsGenerator underTest;

    @Test
    public void fromItems() throws Exception {
        Stats stats = underTest.fromItems(Arrays.asList(ItemType.SWORD));
        assert stats.getStrength() == 5;
    }

}