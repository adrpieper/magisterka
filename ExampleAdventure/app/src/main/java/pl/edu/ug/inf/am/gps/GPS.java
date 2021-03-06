package pl.edu.ug.inf.am.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GPS {

    private final LocationManager locationManager;
    private final LocationListener locationListener;
    private final Context context;
    private boolean running;
    private GPSListener listener;

    @Inject
    public GPS(final Context context) {
        this.context = context;
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                Log.d("LOCATION", "GPS loc changed");
                if (listener != null) {
                    Log.d("LOCATION", "listener ok");
                    Log.d("LOCATION", location.toString());
                    listener.onLocationChanged(location);
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };
    }

    public void stop() throws CantUseGPSException{
        checkIfGpsEnabled();
        try {
            locationManager.removeUpdates(locationListener);
            running = false;
        }catch (SecurityException e){
            throw new CantUseGPSException();
        }
    }

    public void start() throws CantUseGPSException {
        checkIfGpsEnabled();
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
            running = true;
        }catch (SecurityException e){
            throw new CantUseGPSException();
        }
    }

    public void setListener(GPSListener listener) {
        this.listener = listener;
    }

    public boolean isRunning() {
        return running;
    }

    private void checkIfGpsEnabled() throws CantUseGPSException {
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            throw new CantUseGPSException();
        }
    }

    public interface GPSListener {
        void onLocationChanged(Location location);
    }
}
