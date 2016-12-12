package pl.edu.ug.inf.am.gps.view;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.gps.CantUseGPSException;
import pl.edu.ug.inf.am.gps.GPS;

import javax.inject.Inject;

public class GPSSwitch extends Switch {

    @Inject
    GPS gps;


    public GPSSwitch(Context context) {
        super(context);
        init();
    }

    public GPSSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        App.getComponent(GameComponent.class).inject(this);
        setChecked(gps.isRunning());
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (gps.isRunning()) {
                        gps.stop();
                    } else {
                        gps.start();
                    }
                } catch (CantUseGPSException e) {
                    Toast.makeText(getContext(), "Can't use gps", Toast.LENGTH_SHORT).show();
                }
                setChecked(gps.isRunning());
            }
        });
    }
}
