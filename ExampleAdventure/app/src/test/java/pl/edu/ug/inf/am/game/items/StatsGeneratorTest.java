package pl.edu.ug.inf.am.game.items;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.Stats;
import pl.aml.items.ItemType;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2016-12-06.
 */
@RunWith(MockitoJUnitRunner.class)
public class StatsGeneratorTest {
    @InjectMocks
    private StatsGenerator underTest;

    @Test
    public void fromItems() throws Exception {
        Stats stats = underTest.fromItems(Arrays.asList(ItemType.SWORD));
        assert stats.getStrength() == 5;
    }

}