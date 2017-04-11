package pl.edu.ug.inf.am.game.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.aml.character.Stats;
import pl.edu.ug.inf.am.game.items.ItemsStatsGenerator;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.game.state.PlayerState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static pl.edu.ug.inf.am.game.player.PlayerStatsUpdater.*;

/**
 * Created by Adi on 2017-04-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerStatsUpdaterTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private PlayerStatsState playerStatsState;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private ItemsState itemsState;
    @Mock
    private ItemsStatsGenerator itemsStatsGenerator;
    @Mock
    private BasicStatsGenerator basicStatsGenerator;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private PlayerState playerState;
    @InjectMocks
    private PlayerStatsUpdater underTest;

    public static final Stats BASIC_STATS = new Stats(10, 20, 30);
    public static final Stats BONUS_STATS = new Stats(5, 10, 15);
    public static final Stats FULL_STATS = new Stats(15, 30, 45);

    @Test
    public void updateBasicStats() throws Exception {

        when(basicStatsGenerator.generate(playerState.getLevel(), playerState.getCharacterType())).thenReturn(BASIC_STATS);
        when(playerStatsState.getFull()).thenReturn(FULL_STATS);

        underTest.updateBasicStats();

        verify(playerStatsState).setBasic(BASIC_STATS);
        verifyUpdateHpAndMp();
    }

    @Test
    public void updateBonusStats() throws Exception {

        when(itemsStatsGenerator.fromItems(itemsState.getItemsOnSlot().values())).thenReturn(BONUS_STATS);
        when(playerStatsState.getFull()).thenReturn(FULL_STATS);

        underTest.updateBonusStats();

        verify(playerStatsState).setBonus(BONUS_STATS);
        verifyUpdateHpAndMp();
    }

    private void verifyUpdateHpAndMp() {
        final int hp = FULL_STATS.getStrength() * HP_PER_LEVEL + BASE_HP;
        verify(playerState.getHp()).setMaxValue(hp);
        verify(playerState.getHp()).setValue(hp);
        final int mp = FULL_STATS.getIntelligence() * MP_PER_LEVEL + BASE_MP;
        verify(playerState.getMp()).setMaxValue(mp);
        verify(playerState.getMp()).setValue(mp);
    }

}