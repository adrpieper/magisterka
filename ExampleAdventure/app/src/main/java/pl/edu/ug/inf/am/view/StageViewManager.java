package pl.edu.ug.inf.am.view;

import pl.edu.ug.inf.am.stage.StageState;

/**
 * Created by Adi on 2016-11-02.
 */
public interface StageViewManager<T extends StageState> {

    void showState(T state, GameActivity gameActivity);
}
