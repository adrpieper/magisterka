package pl.edu.ug.inf.am.adventure.model;

/**
 * Created by Adi on 2016-11-03.
 */
public class ResultModel {
    private final int gainedExp;

    public ResultModel(int gainedExp) {
        this.gainedExp = gainedExp;
    }

    public int getGainedExp() {
        return gainedExp;
    }
}
