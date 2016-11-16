package pl.edu.ug.inf.am.adventure.fight.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import pl.edu.ug.inf.am.BR;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

import javax.inject.Inject;

@PerAdventureStage
public class FightConsoleModel extends BaseObservable {

    private String message = "";

    @Inject
    public FightConsoleModel() {
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }
}
