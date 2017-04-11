package pl.edu.ug.inf.am.game.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;
import pl.edu.ug.inf.am.game.player.PlayerStatsUpdater;
import pl.edu.ug.inf.am.game.state.GameState;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Adi on 2017-04-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameInitializerTest {
    @Mock
    private GameState gameState;
    @Mock
    private GameSubComponentManager gameSubComponentManager;
    @Mock
    private PlayerStatsUpdater statsUpdater;
    @InjectMocks
    private GameInitializer underTest;

    @Test
    public void init_whenGameIsCreated() throws Exception {

        when(gameState.getState()).thenReturn(GameState.State.CREATED);

        underTest.init();

        verify(gameSubComponentManager).startTrip();
        verify(statsUpdater).updateBasicStats();
        verify(statsUpdater).updateBonusStats();
        verify(gameState).setState(GameState.State.RUNNING);
    }

    @Test
    public void init_whenGameIsContinued() throws Exception {

        when(gameState.getState()).thenReturn(GameState.State.CONTINUED);

        underTest.init();

        verify(gameSubComponentManager).startTrip();
        verify(statsUpdater).updateBasicStats();
        verify(statsUpdater).updateBonusStats();
        verify(gameState).setState(GameState.State.RUNNING);
    }

    @Test
    public void init_whenGameIsRunning() throws Exception {

        when(gameState.getState()).thenReturn(GameState.State.RUNNING);

        underTest.init();


        verifyZeroInteractions(gameSubComponentManager);
        verifyZeroInteractions(statsUpdater);
        verifyZeroInteractions(statsUpdater);
        verify(gameState).getState();
        verifyNoMoreInteractions(gameState);

    }


}