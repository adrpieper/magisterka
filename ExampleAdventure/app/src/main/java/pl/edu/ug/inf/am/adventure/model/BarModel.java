package pl.edu.ug.inf.am.adventure.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.player.state.BarState;

public class BarModel extends BaseObservable{
    private final int maxValue;
    private int value;

    public BarModel(BarState bar) {
        this.maxValue = bar.getMaxValue();
        this.value = bar.getValue();
    }

    public BarModel(int value) {
        this.maxValue = value;
        this.value = value;
    }

    @Bindable
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    public int getMaxValue() {
        return maxValue;
    }
}
