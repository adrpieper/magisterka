package pl.edu.ug.inf.am.game.player;

import pl.aml.character.Stats;
import pl.edu.ug.inf.am.game.dagger.PerGame;
import pl.edu.ug.inf.am.game.items.ItemsStatsGenerator;
import pl.edu.ug.inf.am.game.state.ItemsState;
import pl.edu.ug.inf.am.game.state.PlayerState;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;

import javax.inject.Inject;

@PerGame
public class PlayerStatsUpdater {

    private final PlayerStatsState playerStatsState;
    private final ItemsState itemsState;
    private final ItemsStatsGenerator itemsStatsGenerator;
    private final BasicStatsGenerator basicStatsGenerator;
    private final PlayerState playerState;

    @Inject
    public PlayerStatsUpdater(PlayerStatsState playerStatsState, ItemsState itemsState, ItemsStatsGenerator itemsStatsGenerator, BasicStatsGenerator basicStatsGenerator, PlayerState playerState) {
        this.playerStatsState = playerStatsState;
        this.itemsState = itemsState;
        this.itemsStatsGenerator = itemsStatsGenerator;
        this.basicStatsGenerator = basicStatsGenerator;
        this.playerState = playerState;
    }

    public void updateBasicStats() {
        Stats stats = basicStatsGenerator.generate(playerState.getLevel(), playerState.getCharacterType());
        playerStatsState.setBasic(stats);
        updateHpAndMp();
    }

    public void updateBonusStats() {
        Stats stats = itemsStatsGenerator.fromItems(itemsState.getItemsOnSlot().values());
        playerStatsState.setBonus(stats);
        updateHpAndMp();
    }

    public void updateHpAndMp(){
        Stats stats = playerStatsState.getFull();
        final int hp = stats.getStrength() * 10+100;
        playerState.getHp().setMaxValue(hp);
        playerState.getHp().setValue(hp);
        final int mpValue = stats.getIntelligence() * 10+100;
        playerState.getMp().setMaxValue(mpValue);
        playerState.getMp().setValue(mpValue);
    }
}
