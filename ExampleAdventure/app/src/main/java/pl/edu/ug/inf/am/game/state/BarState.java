package pl.edu.ug.inf.am.game.state;

public class BarState {
    private int maxValue;
    private int value;

    public BarState(int maxValue) {
        this.maxValue = maxValue;
        this.value = maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getValue() {
        return value;
    }
}
