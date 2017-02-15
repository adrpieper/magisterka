package pl.edu.ug.inf.am.trip.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.aml.character.Stats;
import pl.aml.item.Bonus;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.game.state.PlayerStatsState;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;

import javax.inject.Inject;

@PerTrip
public class StatsModel extends BaseObservable {

    private final PlayerStatsState state;
    private Stats bonus;

    @Inject
    public StatsModel(PlayerStatsState state) {

        this.state = state;
    }

    public Stats getBasic() {
        return state.getBasic();
    }

    public void setBonus(Stats bonus) {
        this.bonus = bonus;
        notifyPropertyChanged(BR.bonus);
    }

    @Bindable
    public Stats getBonus() {
        return state.getBonus();
    }

    public Stats getFull() {
        return state.getBasic().plus(bonus);
    }
}
